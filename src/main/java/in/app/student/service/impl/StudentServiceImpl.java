package in.app.student.service.impl;

import in.app.student.dao.GenericDAO;
import in.app.student.dao.StudentDAO;
import in.app.student.entity.Student;
import in.app.student.service.StudentService;
import in.app.student.utils.MD5Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl extends GenericServiceImpl<Student> implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public GenericDAO<Student, Integer> getBaseDAO() {
        return studentDAO;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void saveStudent(Student student) {
        student.setPassword(MD5Utility.md5(student.getPassword()));
        studentDAO.create(student);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void deleteStudent(Integer studentId) {
        Student student = studentDAO.findById(studentId);
        if(student!=null)
            studentDAO.delete(student);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public Student fetchStudentById(int studentId) {
        return studentDAO.findById(studentId);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public Student findByEmailAndPassword(String email, String password) {
        password = MD5Utility.md5(password);
        return studentDAO.findByEmailAndPassword(email, password);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public Student findByEmail(String email){
        return studentDAO.findByEmail(email);
    }
}
