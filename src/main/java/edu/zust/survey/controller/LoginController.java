package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IManagerService;
import edu.zust.survey.service.IQuestionnaireService;
import edu.zust.survey.service.IStudentService;
import edu.zust.survey.vo.QuestionnaireModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Lee on 2017/10/19.
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private IManagerService managerService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IQuestionnaireService questionnaireService;

    @RequestMapping(value = "student", method = RequestMethod.POST )
    public String doStudentLogin(HttpSession session, String username, String password, Model model){
        Student student = studentService.login(username, password);

        if (student != null){
            if (student.getAnswered() == 1){
                //已经答题
                return "thanks";
            }
            session.setAttribute(Const.CURRENT_USER, student);
            addMajorTable(session);

            QuestionnaireModel questionnaireModel = questionnaireService.getQuestionnaireModel(student);
            model.addAttribute(Const.QUESTIONNAIRE_MODEL, questionnaireModel);
            return "survey";
        }
        return "loginFailed";

    }

    @RequestMapping(value = "manager", method = RequestMethod.POST)
    public String doManagerLogin(HttpSession session, String username, String password, Model model){
        Manager manager = managerService.login(username, password);
        if (manager != null){
            session.setAttribute(Const.CURRENT_USER, manager);
            addMajorTable(session);
            return "backend";
        }
        return "loginFailed";
    }

    private void addMajorTable(HttpSession session){
        if(session.getServletContext().getAttribute(Const.MAJOR_TABLE)==null){
            String[] majorTable = {"","软件工程","计算机科学与技术","数字媒体技术","电子信息工程","物联网工程","通信工程"};
            session.getServletContext().setAttribute(Const.MAJOR_TABLE,majorTable);
        }
    }
}
