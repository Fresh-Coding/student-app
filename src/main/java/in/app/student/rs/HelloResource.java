package in.app.student.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

/**
 * This is hello world web service
 * @author HP
 *
 */
@Component
@Path("/hellors")
public class HelloResource {
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/test")
	public String hello(){
    	return "Working";
    }
}
