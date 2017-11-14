package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IQuestionnaireService;
import edu.zust.survey.vo.QuestionnaireModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Lee on 2017/11/13.
 */
@Controller
@RequestMapping("/")
public class QuestionnaireController {

    @Autowired
    private IQuestionnaireService questionnaireService;

    @RequestMapping(value = "student/questionnaire/{}", method = RequestMethod.GET)
    public String getQuestionnaireModel(HttpSession session, Model model){
        Student student = (Student) session.getAttribute(Const.CURRENT_USER);
        Integer majorId = student.getMajorId();

        QuestionnaireModel questionnaire = questionnaireService.assembleQuestionnaireModel();
        model.addAttribute(Const.QUESTIONNAIRE, questionnaire);
        String[] majorTable = {"","软件工程","计算机科学与技术","数字媒体技术","电子信息工程","物联网工程","通信工程"};
        model.addAttribute(Const.MAJOR_TABLE,majorTable);
        return "survey";
    }
}
