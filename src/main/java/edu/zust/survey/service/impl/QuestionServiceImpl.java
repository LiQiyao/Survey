package edu.zust.survey.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import edu.zust.survey.common.QuestionnaireCache;
import edu.zust.survey.dao.QuestionDAO;
import edu.zust.survey.entity.Answer;
import edu.zust.survey.entity.Question;
import edu.zust.survey.service.IQuestionService;
import edu.zust.survey.vo.CustomQuestion;
import edu.zust.survey.vo.Design;
import edu.zust.survey.vo.Questionnaire;
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
    private QuestionDAO questionDAO;

    @Autowired
    private QuestionnaireCache questionnaireCache;

    public Questionnaire getAllQuestions(Integer majorId){
        if (questionnaireCache.getQuestionnaire(majorId) != null){
            questionnaireCache.putQuestionnaire(majorId, new Questionnaire(questionDAO.getPart1(majorId), questionDAO.getPart2(majorId)));
        }
        return questionnaireCache.getQuestionnaire(majorId);
    }

    @Transactional
    public boolean addQuestions(Integer majorId, String jsonString) {
        Gson gson = new Gson();
        Design design = gson.fromJson(jsonString, Design.class);
        System.out.println(design);
        List<Question> questions = Lists.newArrayList();
        Question question;
        Answer answer;
        List<Answer> answers;
        for (String s : design.getPart1()){
            question = new Question();
            question.setMajorId(majorId);
            question.setQuestionContent(s);
            question.setType(1);
            question.setAnswers(Lists.newArrayList(new Answer("完全达到", question), new Answer("基本达到",question), new Answer("未达到", question), new Answer("差距很大", question)));
            questions.add(question);
        }
        for (CustomQuestion cq : design.getPart2()){
            question = new Question();
            question.setMajorId(majorId);
            question.setQuestionContent(cq.getQuestionContent());
            question.setType(1);
            answers = Lists.newArrayList();
            for (String as : cq.getAnswerContent()){
                answers.add(new Answer(as, question));
            }
            question.setAnswers(answers);
            questions.add(question);
        }
        System.out.println(questions);
        for (Question q : questions){
            questionDAO.insertQuestion(q);
        }
        return true;
    }

    @Transactional
    public boolean modifyQuestions(Integer majorId, String jsonString) {
        System.out.println("mmmmmmm");
        questionDAO.deleteQuestion(majorId);
        //addQuestions(majorId, jsonString);
        return true;
    }
}
