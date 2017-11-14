package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
@Controller
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /*
        提交回答
     */
    @RequestMapping(value = "/submitAnswer", method = RequestMethod.POST)
    public String submitAnswer(HttpSession session, HttpServletRequest req){
        Student student = (Student)session.getAttribute(Const.CURRENT_USER);
        int studentId = student.getId();
        Map<String, String[]> map = req.getParameterMap();
        studentService.answerQuestions(studentId, map);
        return "thanks";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.setAttribute(Const.CURRENT_USER, null);
        return "";
    }


}
