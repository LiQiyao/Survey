package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.common.QuestionnaireCache;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IQuestionService;
import edu.zust.survey.vo.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "student/question/getAllQuestions", method = RequestMethod.GET)
    public String getAllQuestions(HttpSession session){
        //Student student = (Student) session.getAttribute(Const.CURRENT_USER);
        //Integer majorId = student.getMajorId();
        System.out.println(questionService.getAllQuestions(1));
        return null;
    }

    @RequestMapping(value = "admin/question/addQuestion", method = RequestMethod.GET)
    public String addQuestion(HttpSession session, String jsonString){
        jsonString = "{'part1':['问题1','问题2'],'part2':[{'questionContent':'你为什么要自定义问题啊','answerContent':['知道','不知道']},{'questionContent':'你为什么要自定义问题2','answerContent':['知道','不知道']}]}";
        questionService.addQuestions(jsonString);
        return "";
    }
}
