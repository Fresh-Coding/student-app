package in.app.student;

import in.app.student.common.AbstractDAOTest;
import in.app.student.dao.GenericDAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDAOTest<T, PK extends Serializable> extends AbstractDAOTest {

	@Resource
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	private GenericDAO<T,PK> dao;

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public GenericDAO<T,PK> getDao() {
		return dao;
	}
	public void setDao(GenericDAO<T,PK> dao) {
		this.dao = dao;
	}

}
