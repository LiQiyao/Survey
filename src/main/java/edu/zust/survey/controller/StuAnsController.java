package edu.zust.survey.controller;

import edu.zust.survey.common.Const;
import edu.zust.survey.dao.StudentDAO;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IStudentService;
import edu.zust.survey.service.ISuggestionService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
@Controller
public class StuAnsController {

    @Autowired
    private ISuggestionService suggestionService;

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/student/stuAns/submitAnswer", method = RequestMethod.GET)
    public String submitAnswer(HttpSession session, HttpServletRequest req){
        Map<String, String[]> map = req.getParameterMap();
        String[] temp;
        String value;
        for (String key : map.keySet()){
            temp = map.get(key);
            value = temp[0];
            System.out.println(key + " " + value +"!!!");
            if ("suggestionContent".equals(key)){
                suggestionService.addSuggestion(1, value);
            } else {

            }
        }

        return "";
    }

}
