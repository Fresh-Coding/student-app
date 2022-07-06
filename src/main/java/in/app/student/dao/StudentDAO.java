package in.app.student.dao;

import in.app.student.entity.Student;

public interface StudentDAO extends GenericDAO<Student,Integer> {
    Student findByEmailAndPassword(String email, String password);
    Student findByEmail(String email);
}
