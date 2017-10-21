package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.dao.StudentDAO;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IStuAnsService;
import edu.zust.survey.service.IStudentService;
import edu.zust.survey.service.ISuggestionService;
import org.hibernate.SessionFactory;
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
public class StuAnsController {

    @Autowired
    private IStuAnsService stuAnsService;

    @RequestMapping(value = "/student/stuAns/submitAnswer", method = RequestMethod.POST)
    public String submitAnswer(HttpSession session, HttpServletRequest req){
        Student student = (Student)session.getAttribute(Const.CURRENT_USER);
        int studentId = student.getId();
        Map<String, String[]> map = req.getParameterMap();
        stuAnsService.answerQuestions(studentId, map);
        return "thanks";
    }
}
