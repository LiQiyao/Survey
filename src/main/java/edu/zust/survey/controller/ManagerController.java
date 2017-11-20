package edu.zust.survey.controller;

import com.google.gson.Gson;
import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.service.IManagerService;
import edu.zust.survey.service.IQuestionnaireService;
import edu.zust.survey.service.IStatisticService;
import edu.zust.survey.vo.DesignModel;
import edu.zust.survey.vo.QuestionnaireModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private IStatisticService statisticService;

    @Autowired
    private IQuestionnaireService questionnaireService;

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.setAttribute(Const.CURRENT_USER, null);
        return "login";
    }

    @RequestMapping(value = "manager", method = RequestMethod.POST)
    public String createManager(String username, String password, Integer majorId){
        managerService.addManager(username, password, majorId);
        return "index";
    }

    @RequestMapping(value = "designModels/{questionnaireId}", method = RequestMethod.GET)
    public String getDesignModel(HttpSession session, Model model,@PathVariable Integer questionnaireId){
        Manager manager = (Manager)session.getAttribute(Const.CURRENT_USER);
        if (questionnaireId != null){
            DesignModel designModel = questionnaireService.assembleDesignModel(questionnaireId);
            if (designModel.getPart1().size() == 0 && designModel.getPart2().size() == 0){
                model.addAttribute("newDesignModel", 1);
            }else {
                model.addAttribute("newDesignModel", 0);
            }
            Gson gson = new Gson();
            String json = gson.toJson(designModel);
            model.addAttribute(Const.DESIGN_MODEL, json);
            model.addAttribute("questionnaireId",questionnaireId);
        }
        return "design";
    }

    @RequestMapping(value = "statistics/questionnaireId/{questionnaireId}/grade/{grade}", method = RequestMethod.GET)
    public String getStatic(HttpSession session, Model model, @PathVariable Integer questionnaireId, @PathVariable Integer grade){
        Manager manager = (Manager)session.getAttribute(Const.CURRENT_USER);
        if (manager != null && questionnaireId != null && grade != null){
            Integer majorId = manager.getMajorId();
            model.addAttribute(Const.STUDENT_COUNT, statisticService.getCountSum(majorId, grade));
            model.addAttribute(Const.ANSWERED_COUNT, statisticService.getAnsweredCountSum(majorId, grade));
            model.addAttribute(Const.RESULT_MAP, statisticService.getStatisticResultMap(questionnaireId, grade));//通过answerId获取回答的人数
            model.addAttribute(Const.SUGGESTION_TABLE, statisticService.getSuggestionList(majorId));
            QuestionnaireModel questionnaireModel = questionnaireService.getQuestionnaireModel(questionnaireId, grade);
            model.addAttribute(Const.QUESTIONNAIRE_MODEL, questionnaireModel);
        }
        return "statistics";
    }

    @RequestMapping(value = "answerSheets/{studentId}", method = RequestMethod.GET)
    public String getAnswerSheet(HttpSession session, Model model, @PathVariable Integer studentId){
        model.addAttribute(Const.ANSWER_SHEET_VO, managerService.assembleAnswerSheetVo(studentId));
        return "test";
    }

    @RequestMapping(value = "answerSheets/batchExport/{grade}", method = RequestMethod.GET)
    public String batchExport(HttpSession session, HttpServletResponse response, @PathVariable Integer grade){
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            Integer majorId = manager.getMajorId();
        }
        managerService.getAllAnswerSheet(4, 1, session.getServletContext().getRealPath("/"), response);
        return "";
    }

    @RequestMapping(value = "excel/import", method = RequestMethod.POST)
    public String importExcel(HttpSession session, MultipartFile file, HttpServletRequest request){

        return "";
    }
}
