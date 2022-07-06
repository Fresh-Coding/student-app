package in.app.student.controller;

import in.app.student.common.StudentAppConstants;
import in.app.student.common.URLConstants;
import in.app.student.domain.DMLogin;
import in.app.student.entity.AdminLogin;
import in.app.student.entity.Student;
import in.app.student.service.AdminLoginService;
import in.app.student.service.StudentService;
import in.app.student.utils.SessionUtility;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = URLConstants.PREFIX_AUTH)
public class LoginController {
    @Autowired
    private AdminLoginService adminLoginService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = URLConstants.LOGIN)
    public String loginPage(){
        return "login";
    }


    @RequestMapping(value = URLConstants.PROCESS_LOGIN, method = RequestMethod.POST)
    public String processLogin(DMLogin dmLogin, HttpSession session,
                               HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes){
        AdminLogin adminLogin = adminLoginService.findByEmailAndPassword(dmLogin.getEmail(), dmLogin.getPassword());
        if(adminLogin != null){
            SessionUtility.setUserId(adminLogin.getId(), session);
            SessionUtility.setLoginType(StudentAppConstants.LOGIN_TYPE_ADMIN, session);
            SessionUtility.setName(adminLogin.getFullName(), session);
            return URLConstants.CONTEXT_REDIRECT + URLConstants.STUDENT_LIST;
        }

        Student studentLogin = studentService.findByEmailAndPassword(dmLogin.getEmail(), dmLogin.getPassword());
        if(studentLogin!=null) {
            SessionUtility.setUserId(studentLogin.getStudentId(), session);
            SessionUtility.setLoginType(StudentAppConstants.LOGIN_TYPE_STUDENT, session);
            SessionUtility.setName((studentLogin.getFirstName()+studentLogin.getLastName()), session);
            return URLConstants.CONTEXT_REDIRECT + URLConstants.STUDENT_DASHBOARD;
        }

        redirectAttributes.addFlashAttribute("MSG_ERROR","Invalid username or password.");
        return URLConstants.CONTEXT_REDIRECT+ URLConstants.PREFIX_AUTH +  URLConstants.LOGIN;
    }

    @RequestMapping(value = URLConstants.LOGOUT, method = RequestMethod.GET)
    public String processLogout(HttpSession session){
            session.invalidate();
            return URLConstants.CONTEXT_REDIRECT + URLConstants.HOME;
    }


}
