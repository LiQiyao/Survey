package edu.zust.survey.service.impl;

import com.google.gson.Gson;
import edu.zust.survey.common.QuestionnaireCache;
import edu.zust.survey.dao.QuestionDAO;
import edu.zust.survey.service.IQuestionService;
import edu.zust.survey.vo.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private QuestionnaireCache questionnaireCache;

    public Questionnaire getAllQuestions(Integer majorId){
        if (questionnaireCache.getQuestionnaire(majorId) != null){
            questionnaireCache.putQuestionnaire(majorId, new Questionnaire(questionDAO.getPart1(majorId), questionDAO.getPart2(majorId)));
        }
        return questionnaireCache.getQuestionnaire(majorId);
    }

    public boolean addQuestions(String jsonString) {
        Gson gson = new Gson();
        Questionnaire questionnaire = gson.fromJson(jsonString, Questionnaire.class);
        return true;
    }
}
