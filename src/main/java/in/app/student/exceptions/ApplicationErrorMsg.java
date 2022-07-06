package in.app.student.exceptions;

// Ref code : http://www.tutorialspoint.com/spring/spring_exception_handling_example.htm
public class ApplicationErrorMsg extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public ApplicationErrorMsg() {

	}

	public ApplicationErrorMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return msg;
	}

}
