package in.app.student.service;

import in.app.student.entity.Student;

import java.util.List;

public interface StudentService extends GenericService<Student>{
    void saveStudent(Student student);
    void deleteStudent(Integer studentId);
    Student fetchStudentById(int studentId);
    //Student login(String email, String password);
    Student findByEmailAndPassword(String email, String password);
    Student findByEmail(String email);
}
