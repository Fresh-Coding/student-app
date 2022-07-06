package in.app.student.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Repository;

@Repository
@Provider
public class TeacheronExceptionHandler implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException exception) {

		if (exception instanceof ValidationException) {
			final ValidationException vex = (ValidationException) exception;
			return Response.status(Status.PRECONDITION_FAILED).entity(vex.getViolationConstraintsMessage())
					.type(MediaType.APPLICATION_JSON).build();
		} else if (exception instanceof TeacheronException) {
			TeacheronException teacheronException = (TeacheronException) exception;
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(teacheronException.getMessages()).type(MediaType.APPLICATION_JSON)
					.build();
		} else {
			exception.printStackTrace();
			TeacheronException teacheronException = new TeacheronException();
			List<ErrorMessageModel> messages = new ArrayList<>(1);
			ErrorMessageModel errorMessageModel = new ErrorMessageModel("exception_generic_error");
			messages.add(errorMessageModel);
			teacheronException.setMessages(messages);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(teacheronException.getMessages()).type(MediaType.APPLICATION_JSON)
					.build();
		}

	}
}
