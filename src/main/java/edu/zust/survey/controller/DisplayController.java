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
import org.springframework.web.bind.annotation.ResponseBody;

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
            model.addAttribute(Const.DISPLAY_FORM_LIST, displayFormService.assembleGradeChoiceVos(manager.getMajorId()));
            return "gradeManage";
        }
        return "";
    }

    @RequestMapping(value = "displayForms", method = RequestMethod.POST)
    @ResponseBody
    public boolean modifyDisplayForm(HttpSession session, HttpServletRequest request){
        Manager manager = (Manager) session.getAttribute(Const.CURRENT_USER);
        if (manager != null){
            int majorId = manager.getMajorId();
            displayFormService.modifyDisplayForm(majorId, request);
            return true;
        }
        return false;
    }
}
