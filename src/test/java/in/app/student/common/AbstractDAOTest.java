package in.app.student.common;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-applicationContext.xml"})
@Transactional
public abstract class AbstractDAOTest extends AbstractTest implements ApplicationContextAware {

	private static SessionFactory LastSessionFactory;
	private static boolean LastTestFinished = true;

	@Resource
	private SessionFactory sessionFactory;
	private ApplicationContext applicationContext;
	
	private IDatabaseConnection connection;
	private IDataSet dataSet;

	@BeforeTransaction
	public void setUpDB() throws Exception {
		// clear DB if H2 got corrupted through an exception
		if (!LastTestFinished) {
			clearDB();
		}
		// re-populate if hibernate session factory has changed or DB got cleared
		if (LastSessionFactory != sessionFactory || !LastTestFinished) {
			populateDB();
			LastSessionFactory = sessionFactory;
		}
	}

	@Before
	public void setUp() throws Exception {
		LastTestFinished = false;
	}

	@After
	public void tearDown() throws Exception {
		sessionFactory.getCurrentSession().flush();
		LastTestFinished = true;
	}


	/**
	 * Returns the testing dataset. Start with an empty database.
	 * 
	 * @return the testing dataset
	 */
	protected IDataSet getDataSet() throws Exception {
		if (dataSet == null) {
			FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
			flatXmlDataSetBuilder.setColumnSensing(true);
			final InputStream is = getClass().getResourceAsStream("/dataset.xml");
			try {
				dataSet = flatXmlDataSetBuilder.build(is);
			} finally {
				is.close();
			}
		}
		return dataSet;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Rollback(false)
	private void populateDB() throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
	}

	private void clearDB() throws SQLException {
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ((SessionImpl) session).connection();
			stmt = conn.createStatement();
			stmt.execute("drop all objects;");
			conn.commit();
			new SchemaExport(applicationContext.getBean(org.springframework.orm.hibernate4.LocalSessionFactoryBean.class)
					.getConfiguration()).create(false, true);
		} catch (Exception e) {
			if (conn != null) {
				conn.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
	

	private IDatabaseConnection getConnection() throws HibernateException, DatabaseUnitException {
		if (connection == null) {
			Session session = SessionFactoryUtils.openSession(sessionFactory);
			IDatabaseConnection connection = new DatabaseConnection(((SessionImpl) session).connection());
			connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
			this.connection = connection;
		}
		return connection;
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
