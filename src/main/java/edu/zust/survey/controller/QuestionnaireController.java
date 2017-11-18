package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IQuestionnaireService;
import edu.zust.survey.vo.QuestionnaireModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

/*    @RequestMapping(value = "student/questionnaire", method = RequestMethod.GET)
    public String getQuestionnaireModel(HttpSession session, Model model){
        Student student = (Student) session.getAttribute(Const.CURRENT_USER);
        QuestionnaireModel questionnaire = questionnaireService.assembleQuestionnaireModel(student);
        model.addAttribute(Const.QUESTIONNAIRE_MODEL, questionnaire);
        String[] majorTable = {"","软件工程","计算机科学与技术","数字媒体技术","电子信息工程","物联网工程","通信工程"};
        model.addAttribute(Const.MAJOR_TABLE,majorTable);
        return "survey";
    }*/

    @RequestMapping(value = "admin/questionnaires", method = RequestMethod.POST)
    public String createQuestionnaireModel(HttpSession session, String jsonString){
        //jsonString = "{'part1':['问题1','问题2'],'part2':[{'questionContent':'你为什么要自定义问题啊','answerContent':['知道','不知道']},{'questionContent':'你为什么要自定义问题2','answerContent':['知道','不知道']}]}";
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            questionnaireService.createQuestionnaire(manager.getMajorId(), jsonString, null);
            return "designSucceed";
        }
        return "loginFailed";
    }

    @RequestMapping(value = "admin/questionnaires/{questionnaireId}", method = RequestMethod.PUT)
    public String modifyQuestion(HttpSession session, String jsonString, @PathVariable Integer questionnaireId){
        //jsonString = "{'part1':['问题1','问题2'],'part2':[{'questionContent':'你为什么要自定义问题啊','answerContent':['知道','不知道']},{'questionContent':'你为什么要自定义问题2','answerContent':['知道','不知道']}]}";
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            questionnaireService.modifyQuestionnaireModel(manager.getMajorId(), questionnaireId, jsonString);
            return "";
        }
        return "";
    }

    @RequestMapping(value = "admin/questionnaires/{questionnaireId}", method = RequestMethod.DELETE)
    public String deleteQuestionnaire(HttpSession session, @PathVariable Integer questionnaireId){
        if (questionnaireService.deleteQuestionnaireModel(questionnaireId)){
            return "";
        }
        return "";
    }

    @RequestMapping(value = "admin/questionnaires/{questionnaireId}", method = RequestMethod.POST)
    public String chooseQuestionnaire(HttpSession session, @PathVariable Integer questionnaireId){
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            Integer majorId = manager.getMajorId();
            if (questionnaireService.chooseQuestionnaireModel(majorId,questionnaireId)){
                return "";
            }
        }
        return "";
    }
}
