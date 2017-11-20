package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.service.IDisplayFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Lee on 2017/11/15.
 */
@Controller
@RequestMapping("/admin/")
public class DisplayController {

    @Autowired
    private IDisplayFormService displayFormService;

    @RequestMapping(value = "displayForms/list", method = RequestMethod.GET)
    public String getDisplayFormList(HttpSession session, Model model){
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            model.addAttribute(Const.DISPLAY_FORM_LIST, displayFormService.getDisplayFormsByMajorId(manager.getMajorId()));
            return "";
        }
        return "";
    }

    @RequestMapping(value = "displayForms/questionnaireId/{questionnaireId}", method = RequestMethod.GET)
    public String getDisplayFormList(HttpSession session, Model model, @PathVariable Integer questionnaireId){
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            model.addAttribute(Const.DISPLAY_FORMS, displayFormService.getDisplayForms(questionnaireId));
            return "";
        }
        return "";
    }

    @RequestMapping(value = "displayForms/{displayFormId}", method = RequestMethod.PATCH)
    public String modifyDisplayForm(HttpServletRequest request, @PathVariable Integer displayFormId){
        //复选框提取数据
        boolean[] partIsDisplay = {};
        displayFormService.modifyDisplayForm(displayFormId, partIsDisplay);
        return "";
    }
}
