package edu.zust.survey.service.impl;

import edu.zust.survey.dao.StuAnsDAO;
import edu.zust.survey.dao.StudentDAO;
import edu.zust.survey.dao.SuggestionDAO;
import edu.zust.survey.entity.StuAns;
import edu.zust.survey.entity.Suggestion;
import edu.zust.survey.service.IStuAnsService;
import edu.zust.survey.service.ISuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class StuAnsServiceImpl implements IStuAnsService{

    @Autowired
    private StuAnsDAO stuAnsDAO;

    @Autowired
    private ISuggestionService suggestionService;

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public boolean answerQuestions(Integer studentId, Map<String, String[]> map) {
        String[] temp;
        String value;
        for (String key : map.keySet()){
            temp = map.get(key);
            value = temp[0];
            System.out.println(key + " " + value +"!!!");
            if ("suggestionContent".equals(key)){
                suggestionService.addSuggestion(studentId, value);
            } else {
                stuAnsDAO.insertStuAns(new StuAns(studentId, Integer.parseInt(key), Integer.parseInt(value)));
            }
        }
        studentDAO.updateAnsweredStatus(studentId);
        return true;
    }
}
