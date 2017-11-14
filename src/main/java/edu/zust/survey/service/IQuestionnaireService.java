package edu.zust.survey.service;

import edu.zust.survey.entity.Student;
import edu.zust.survey.vo.DesignModel;
import edu.zust.survey.vo.QuestionnaireModel;

/**
 * Created by Lee on 2017/11/10.
 */
public interface IQuestionnaireService {

    boolean createQuestionnaire(Integer majorId, String jsonString, Integer questionnaireId);

    QuestionnaireModel getQuestionnaireModel(Student student);

    QuestionnaireModel getQuestionnaireModel(Integer questionnaireId, Integer grade);

    DesignModel assembleDesignModel(Integer questionnaireId);

    boolean deleteQuestionnaireModel(Integer questionnaireId);

    boolean modifyQuestionnaireModel(Integer majorId, Integer questionnaireId, String jsonString);
}
