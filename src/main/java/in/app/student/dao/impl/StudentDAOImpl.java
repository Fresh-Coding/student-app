package in.app.student.dao.impl;

import in.app.student.dao.StudentDAO;
import in.app.student.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("studentDAO")
public class StudentDAOImpl extends GenericDAOImpl<Student,Integer> implements StudentDAO {

    public StudentDAOImpl(){
        super(Student.class);
    }

    @Override
    public Student findByEmailAndPassword(String email, String password) {
        Criteria criteria = getCriteria(Student.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        return (Student) criteria.uniqueResult();
    }

    @Override
    public Student findByEmail(String email) {
        Criteria criteria = getCriteria(Student.class);
        criteria.add(Restrictions.eq("email", email));
        return (Student) criteria.uniqueResult();
    }
}
