package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.dao.SuggestionDAO;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.entity.Suggestion;
import edu.zust.survey.service.IStatisticService;
import edu.zust.survey.service.ISuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Rin
 * @Date 2017/10/20
 */
@Controller
public class StatisticController {

    @Autowired
    IStatisticService statisticService;

    @RequestMapping(value = "/admin/statistic", method = RequestMethod.GET)
    public String statistic(HttpSession session){
        //Manager manager = (Manager)session.getAttribute(Const.CURRENT_USER);
        int majorId = 1;
        List<Suggestion> suggestionList = statisticService.getSuggestionList(majorId);
        System.out.println(suggestionList);
        //TODO test
        return "";
    }

}
