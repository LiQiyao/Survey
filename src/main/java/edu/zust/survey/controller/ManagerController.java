package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.service.IManagerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Lee on 2017/10/19.
 */
@Controller
@RequestMapping("/admin/")
public class ManagerController {

    @Autowired
    private IManagerService managerService;

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.setAttribute(Const.CURRENT_USER, null);
        return "index";
    }

    @RequestMapping(value = "addManager", method = RequestMethod.GET)
    public String addManager(String username, String password, Integer majorId){
        managerService.addManager(username, password, majorId);
        return "index";
    }
}
