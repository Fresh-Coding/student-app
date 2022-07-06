package in.app.student.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by mypc on 22-07-2017.
 */
public class BaseConfig {

    public ApplicationContext getBaseConfig(){
        Properties properties = System.getProperties();
        properties.setProperty("spring.profiles.active", "Local");

        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        return appContext;
    }
}
