package in.app.student.dao;

import in.app.student.entity.StudentFee;
import org.springframework.stereotype.Repository;

@Repository("studentFeeDao")
public interface StudentFeeDao extends GenericDAO<StudentFee, Integer> {

}
