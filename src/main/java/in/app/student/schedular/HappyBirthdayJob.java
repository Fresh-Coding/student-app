package in.app.student.schedular;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HappyBirthdayJob extends QuartzJobBean{
	
	private HappyBirthdayTask happyBirthdayTask;

	public void setHappyBirthdayTask(HappyBirthdayTask happyBirthdayTask) {
		this.happyBirthdayTask = happyBirthdayTask;
	}

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		happyBirthdayTask.wishHappyBirthday();
	}
}
