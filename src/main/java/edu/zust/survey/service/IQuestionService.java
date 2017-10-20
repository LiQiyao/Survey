package edu.zust.survey.service;

import edu.zust.survey.vo.Design;
import edu.zust.survey.vo.Questionnaire;

/**
 * Created by Lee on 2017/10/19.
 */
public interface IQuestionService {

    Questionnaire getAllQuestions(Integer majorId);

    boolean addQuestions(Integer majorId, String jsonString);

    boolean modifyQuestions(Integer majorId, String jsonString);

    Design assembelDesignModel(Integer majorId);
}
