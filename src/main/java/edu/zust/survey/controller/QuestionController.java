package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.common.QuestionnaireCache;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IQuestionService;
import edu.zust.survey.vo.Questionnaire;
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
@RequestMapping("/")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    //废弃
    /*@RequestMapping(value = "student/question/getAllQuestions", method = RequestMethod.GET)
    public String getAllQuestions(HttpSession session, Model model){
        Student student = (Student) session.getAttribute(Const.CURRENT_USER);
        Integer majorId = student.getMajorId();
        System.out.println(questionService.getAllQuestions(majorId));
        Questionnaire questionnaire = questionService.getAllQuestions(majorId);
        model.addAttribute(Const.QUESTIONNAIRE, questionnaire);
        String[] majorTable = {"","软件工程","计算机科学与技术","数字媒体技术","电子信息工程","物联网工程","通信工程"};
        model.addAttribute(Const.MAJOR_TABLE,majorTable);
        return "survey";
    }*/

    @RequestMapping(value = "admin/question/addQuestion", method = RequestMethod.POST)
    public String addQuestion(HttpSession session, String jsonString){
        //jsonString = "{'part1':['问题1','问题2'],'part2':[{'questionContent':'你为什么要自定义问题啊','answerContent':['知道','不知道']},{'questionContent':'你为什么要自定义问题2','answerContent':['知道','不知道']}]}";
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            questionService.addQuestions(manager.getMajorId(), jsonString);
            return "designSucceed";
        }
        return "loginFailed";
    }

    @RequestMapping(value = "admin/question/modifyQuestion", method = RequestMethod.POST)
    public String modifyQuestion(HttpSession session, String jsonString){
        //jsonString = "{'part1':['问题1','问题2'],'part2':[{'questionContent':'你为什么要自定义问题啊','answerContent':['知道','不知道']},{'questionContent':'你为什么要自定义问题2','answerContent':['知道','不知道']}]}";
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            questionService.modifyQuestions(manager.getMajorId(), jsonString);
            return "designSucceed";
        }
        return "loginFailed";
    }
}
