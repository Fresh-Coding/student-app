package in.app.student.controller;

import in.app.student.common.URLConstants;
import in.app.student.domain.DMStudent;
import in.app.student.domain.DMStudentFee;
import in.app.student.entity.Student;
import in.app.student.entity.StudentFee;
import in.app.student.service.StudentService;
import in.app.student.utils.MapperUtils;
import in.app.student.utils.SessionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    // Test commit.

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = URLConstants.STUDENT_DASHBOARD)
    public String studentDashboard(Map<String, Object> map){

        return "studentDashboard";
    }

    @RequestMapping(value = URLConstants.STUDENT)
    public String studentForm(@RequestParam(value = "id", required = false) Integer id,
                              Map<String,Object> map,
                              final RedirectAttributes redirectAttributes,
                              HttpSession session){
        if(!SessionUtility.isAdmin(session)){
            redirectAttributes.addFlashAttribute("MSG_ERROR","You don't have permission to perform this action");
            return URLConstants.CONTEXT_REDIRECT + URLConstants.STUDENT_DASHBOARD;
        }

        if(id!=null){
            Student student = studentService.fetchStudentById(id);
            map.put("student", student);
            map.put("studentSubmitUrl", URLConstants.APPLICATION_CONTEXT_FULL_PATH + URLConstants.EDIT_STUDENT);
        } else {
            map.put("studentSubmitUrl", URLConstants.APPLICATION_CONTEXT_FULL_PATH + URLConstants.SAVE_STUDENT);
        }
        return "studentForm";
    }

    @RequestMapping(value = URLConstants.SAVE_STUDENT, method = RequestMethod.POST)
    public String saveStudent(DMStudent dmStudent, final RedirectAttributes redirectAttributes){
        // Create entity object from domain
        Student student = MapperUtils.mapStudent(dmStudent);

        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute("MSG", "Student saved successfully.");

        return URLConstants.CONTEXT_REDIRECT+ URLConstants.STUDENT_LIST;
    }

    @RequestMapping(value = URLConstants.STUDENT_LIST)
    public String studentList(Map<String, Object> map){
        System.out.println("inside controller....");
        List<Student> studentList = studentService.findAll();
        map.put("studentList", studentList);
        return "studentList";
    }

    // deleteStudent?id=1
    @RequestMapping(value = URLConstants.DELETE_STUDENT)
    public String deleteStudent(@RequestParam(value = "id") Integer studentId,
                                final RedirectAttributes redirectAttributes){
        studentService.deleteStudent(studentId);
        redirectAttributes.addFlashAttribute("MSG", "Student deleted successfully.");
        return URLConstants.CONTEXT_REDIRECT+URLConstants.STUDENT_LIST;
    }


    @RequestMapping(value=URLConstants.EDIT_STUDENT, method = RequestMethod.POST)
    public String editStudentSave(DMStudent dmStudent,
                                  Map<String,Object> map,
                                  final RedirectAttributes redirectAttributes){

        // Create entity object from domain
        Student student = MapperUtils.mapStudent(dmStudent);
        studentService.update(student);
        redirectAttributes.addFlashAttribute("MSG", "Student updated successfully.");
        return URLConstants.CONTEXT_REDIRECT+URLConstants.STUDENT_LIST;
    }

    @ResponseBody
    @RequestMapping(value = URLConstants.IS_EMAIL_EXISTS)
    public String isEmailExists(@RequestParam("email") String email){
        Student student = studentService.findByEmail(email);
        if(student != null){
            return "Y";
        } else {
            return "N";
        }
    }

    @RequestMapping(value=URLConstants.STUDENT_FEE_FORM, method = RequestMethod.GET)
    public String studentFeeForm(Map<String,Object> map){
        List<Student> studentList = studentService.findAll();
        map.put("studentList", studentList);
        return "studentFeeForm";
    }


    @RequestMapping(value=URLConstants.SAVE_STUDENT_FEE, method = RequestMethod.POST)
    public String saveStudentFee(Map<String,Object> map, DMStudentFee dmStudentFee){
        System.out.println("date is: "+dmStudentFee.getPaymentDate());
        StudentFee studentFee = new StudentFee();
        Student student = new Student();
        student.setStudentId(1);
        studentFee.setStudent(student);

        // take date as string and format it in yyyy-mm-dd HH:MM:ss
        // http://tutorials.jenkov.com/java-internationalization/simpledateformat.html



        return null;
    }

    @RequestMapping(value=URLConstants.STUDENT_LIST_AJAX, method = RequestMethod.GET)
    public String studentListAjax(){
        return "studentListAjax";
    }


}
