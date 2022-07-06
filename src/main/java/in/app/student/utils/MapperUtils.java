package in.app.student.utils;

import in.app.student.domain.DMStudent;
import in.app.student.entity.Student;

// dozer mapping
public class MapperUtils {
    public static Student mapStudent(DMStudent dmStudent){
        Student student = new Student();
        if(dmStudent.getStudentId()!=null) {
            student.setStudentId(dmStudent.getStudentId());
        } else {
            student.setPassword(dmStudent.getPassword());
        }
        student.setFirstName(dmStudent.getFirstName());
        student.setAddress(dmStudent.getAddress());
        student.setEmail(dmStudent.getEmail());
        student.setLastName(dmStudent.getLastName());
        student.setPhoneNumber(dmStudent.getNumber());
        return student;
    }
}
