package edu.zust.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Rin
 * @Date 2017/10/21
 */
@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping(method = RequestMethod.GET)
    public String studentLogin(){
        return "studentLogin";
    }

    @RequestMapping(value = "mng", method = RequestMethod.GET)
    public String managerLogin(){
        return "adminLogin";
    }
}
