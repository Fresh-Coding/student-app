package in.app.student.dao.impl;

import in.app.student.dao.AdminLoginDAO;
import in.app.student.entity.AdminLogin;
import in.app.student.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("adminLoginDAO")
public class AdminLoginDAOImpl extends GenericDAOImpl<AdminLogin,Integer> implements AdminLoginDAO {

    public AdminLoginDAOImpl(){
        super(AdminLogin.class);
    }

    @Override
    public AdminLogin findByEmailAndPassword(String email, String password) {
        Criteria criteria = getCriteria(AdminLogin.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        return (AdminLogin) criteria.uniqueResult();
    }
}
