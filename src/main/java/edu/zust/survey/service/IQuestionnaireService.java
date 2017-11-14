package edu.zust.survey.service;

import edu.zust.survey.vo.DesignModel;
import edu.zust.survey.vo.QuestionnaireModel;

/**
 * Created by Lee on 2017/11/10.
 */
public interface IQuestionnaireService {

    boolean createQuestionnaire(Integer majorId, String jsonString);

    QuestionnaireModel assembleQuestionnaireModel(Integer questionnaireId, Integer grade);

    DesignModel assembleDesignModel(Integer questionnaireId);
}
