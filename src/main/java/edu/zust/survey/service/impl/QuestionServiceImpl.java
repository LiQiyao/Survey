package edu.zust.survey.service.impl;

import com.google.common.collect.Lists;
import edu.zust.survey.common.QuestionnaireCache;
import edu.zust.survey.dao.QuestionMapper;
import edu.zust.survey.entity.Answer;
import edu.zust.survey.entity.Question;
import edu.zust.survey.service.IQuestionService;
import edu.zust.survey.vo.CustomQuestion;
import edu.zust.survey.vo.DesignModel;
import edu.zust.survey.vo.QuestionnaireModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
        private QuestionMapper questionMapper;

    @Autowired
    private QuestionnaireCache questionnaireCache;

/*
    public QuestionnaireModel getAllQuestions(Integer majorId){
        if (questionnaireCache.getQuestionnaire(majorId) == null){
            questionnaireCache.putQuestionnaire(majorId, new QuestionnaireModel(questionDAO.getPart1(majorId), questionDAO.getPart2(majorId)));
        }
        return questionnaireCache.getQuestionnaire(majorId);
    }
*/

/*
    public DesignModel assembleDesignModel(Integer majorId){
        List<Question> qPart1 = questionDAO.getPart1(majorId);
        List<Question> qPart2 = questionDAO.getPart2(majorId);
        List<String> part1 = Lists.newArrayList();
        for (Question q : qPart1){
            part1.add(q.getQuestionContent());
        }
        List<CustomQuestion> part2 = Lists.newArrayList();
        CustomQuestion customQuestion;
        List<String> answers;
        for (Question q : qPart2){
            customQuestion = new CustomQuestion();
            customQuestion.setQuestionContent(q.getQuestionContent());
            answers = Lists.newArrayList();
            for (Answer a : q.getAnswers()){
                answers.add(a.getAnswerContent());
            }
            customQuestion.setAnswerContent(answers);
            part2.add(customQuestion);
        }
        DesignModel designModel = new DesignModel(part1, part2);
        return designModel;
    }
*/



/*    @Transactional
    public boolean modifyQuestions(Integer majorId, String jsonString) {
        System.out.println("mmmmmmm");
        questionDAO.deleteQuestion(majorId);
        addQuestions(majorId, jsonString);
        return true;
    }*/


}
