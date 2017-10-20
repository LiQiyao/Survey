package edu.zust.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lee on 2017/10/19.
 */
@Controller
@RequestMapping("/student/")
public class StudentController {

    @RequestMapping("logout")
    public String logout(){
        return "";
    }
}
