package edu.zust.survey.controller;

import com.google.gson.Gson;
import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.service.IManagerService;
import edu.zust.survey.service.IQuestionService;
import edu.zust.survey.service.IStatisticService;
import edu.zust.survey.vo.Design;
import edu.zust.survey.vo.Questionnaire;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IStatisticService statisticService;

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.setAttribute(Const.CURRENT_USER, null);
        return "redirect:/login.html";
    }

    @RequestMapping(value = "addManager", method = RequestMethod.GET)
    public String addManager(String username, String password, Integer majorId){
        managerService.addManager(username, password, majorId);
        return "index";
    }

    @RequestMapping(value = "getDesignModel", method = RequestMethod.GET)
    public String getDesignModel(HttpSession session, Model model){
        Manager manager = (Manager)session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            Design design = questionService.assembelDesignModel(manager.getMajorId());
            if (design.getPart1().size() == 0 && design.getPart2().size() == 0){
                model.addAttribute("newDesignModel", 1);
            }else {
                model.addAttribute("newDesignModel", 0);
            }
            Gson gson = new Gson();
            String json = gson.toJson(design);
            model.addAttribute(Const.DESIGN, json);
        }
        return "design";
    }

    @RequestMapping(value = "getStatic", method = RequestMethod.GET)
    public String getStatic(HttpSession session, Model model){
        Manager manager = (Manager)session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            Integer majorId = manager.getMajorId();
            model.addAttribute(Const.STUDENT_COUNT, statisticService.getCountSum(majorId));
            model.addAttribute(Const.ANSWERED_COUNT, statisticService.getAnsweredCountSum(majorId));
            model.addAttribute(Const.RESULT_MAP, statisticService.getResultMap(majorId));//通过answerId获取回答的人数
            model.addAttribute(Const.SUGGESTION_TABLE, statisticService.getSuggestionList(majorId));
            Questionnaire questionnaire = questionService.getAllQuestions(majorId);
            model.addAttribute(Const.QUESTIONNAIRE, questionnaire);
        }
        return "statistics";
    }
}
