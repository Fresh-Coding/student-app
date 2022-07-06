package in.app.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupHousekeeper implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupHousekeeper.class);

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        LOGGER.debug("=============StartupHousekeeper============ START");
        System.out.println("inside startupHouseKeeper....");
        LOGGER.debug("=============StartupHousekeeper============ END");
    }


}