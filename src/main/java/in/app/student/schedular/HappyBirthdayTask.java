package in.app.student.schedular;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import in.app.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

public class HappyBirthdayTask implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//private static final Logger LOGGER = LoggerFactory.getLogger("QUARTZ_JOB");

	@Autowired
	private StudentService studentService;

	public void wishHappyBirthday(){
        System.out.println("This is wish happy birthday task...."+ new Date());
		// Call service method and fetch student from database and wish them
    }
}
