package edu.zust.survey.service.impl;

import com.google.common.collect.Maps;
import edu.zust.survey.dao.*;
import edu.zust.survey.entity.Answer;
import edu.zust.survey.entity.Question;
import edu.zust.survey.entity.Suggestion;
import edu.zust.survey.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Rin
 * @Date 2017/10/20
 */
@Service
public class StatisticServiceImpl implements IStatisticService{

    @Autowired
    private SuggestionDAO suggestionDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private StuAnsDAO stuAnsDAO;

    public List<Suggestion> getSuggestionList(int majorId){
        return suggestionDAO.querySuggestions(majorId);
    }

    public Integer getCountSum(Integer majorId){
        return studentDAO.queryCountSum(majorId);
    }

    public Integer getAnsweredCountSum(Integer majorId){
        return studentDAO.queryAnsweredCountSum(majorId);
    }

    public Map<Integer, Integer> getResultMap(Integer majorId) {
        Map<Integer, Integer> resultMap = Maps.newHashMap();
        List<Question> questions = questionDAO.selectAllQuestionsByMajorId(majorId);
        for (Question q : questions){
            for (Answer answer : q.getAnswers()){
                resultMap.put(answer.getId(), stuAnsDAO.queryCountByAnswerId(answer.getId()));
            }
        }
        return resultMap;
    }
}
