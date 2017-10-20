package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IManagerService;
import edu.zust.survey.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "student", method = RequestMethod.GET)
    public String studentLogin(HttpServletResponse resp, HttpSession session, String username, String password){
        Student student = studentService.login(username, password);
        if (student != null){
            if (student.getAnswered() == 1){
                return "";
            }
            session.setAttribute(Const.CURRENT_USER, student);
            System.out.println("登陆!!!");
        }
        return "";
    }

    @RequestMapping("manager")
    public String managerLogin(HttpSession session, String username, String password){
        Manager manager = managerService.login(username, password);
        if (manager != null){
            session.setAttribute(Const.CURRENT_USER, manager);
        }
        return "";
    }
}
