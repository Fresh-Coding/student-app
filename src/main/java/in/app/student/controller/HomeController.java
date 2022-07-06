package in.app.student.controller;

import in.app.student.common.URLConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return URLConstants.CONTEXT_REDIRECT + URLConstants.PREFIX_AUTH + URLConstants.LOGIN;
    }

}
