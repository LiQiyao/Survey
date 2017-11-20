package edu.zust.survey.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import edu.zust.survey.common.GenericBuilder;
import edu.zust.survey.dao.*;
import edu.zust.survey.entity.*;
import edu.zust.survey.service.IDisplayFormService;
import edu.zust.survey.service.IQuestionnaireService;
import edu.zust.survey.vo.CustomQuestion;
import edu.zust.survey.vo.DesignModel;
import edu.zust.survey.vo.QuestionnaireModel;
import edu.zust.survey.vo.SimpleQuestionnaireVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Lee on 2017/11/10.
 */
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private DisplayFormMapper displayFormMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private IDisplayFormService displayFormService;

    @Override
    @Transactional
    public boolean createQuestionnaire(Integer majorId, String jsonString, Integer questionnaireId) {
        Gson gson = new Gson();
        DesignModel designModel = gson.fromJson(jsonString, DesignModel.class);
        System.out.println(designModel);

        //创建问卷
        String questionnaireName = designModel.getName();

        Questionnaire questionnaire = GenericBuilder.of(Questionnaire::new)
                .with(Questionnaire::setName, questionnaireName)
                .with(Questionnaire::setMajorId, majorId)
                .with(Questionnaire::setCreateTime, new Date().getTime())
                .with(Questionnaire::setUpdateTime, new Date().getTime()).build();
        if (questionnaireId != null){
            System.out.println("!!!");
            //创建时制定了id，即属于修改操作，则设置id存入数据库
            questionnaire.setId(questionnaireId);
        }

        questionnaireMapper.insertSelective(questionnaire);
        //获取插入后，mybatis在entity里面写入的id
        questionnaireId = questionnaire.getId();
        List<Question> questions = Lists.newArrayList();
        Question question = null;
        Answer answer = null;
        List<Answer> answers;
        for (String s : designModel.getPart1()){
            /*question = new Question();
            question.setMajorId(majorId);
            question.setQuestionContent(s);
            question.setType(1);
            question.setAnswers(Lists.newArrayList(new Answer("完全达到"), new Answer("基本达到",question), new Answer("未达到", question), new Answer("差距很大", question)));*/
            question = GenericBuilder.of(Question::new).with(Question::setMajorId, majorId)
                    .with(Question::setQuestionContent, s)
                    .with(Question::setType, 1)
                    .with(Question::setQuestionnaireId, questionnaireId)
                    .with(Question::setAnswers,
                            Lists.newArrayList(
                                    GenericBuilder.of(Answer::new).with(Answer::setAnswerContent, "完全达到").build(),
                                    GenericBuilder.of(Answer::new).with(Answer::setAnswerContent, "基本达到").build(),
                                    GenericBuilder.of(Answer::new).with(Answer::setAnswerContent, "未达到").build(),
                                    GenericBuilder.of(Answer::new).with(Answer::setAnswerContent, "差距很大").build())
                    ).build();
            questions.add(question);
        }
        for (CustomQuestion customQuestion : designModel.getPart2()){
/*            question = new Question();
            question.setMajorId(majorId);
            question.setQuestionContent(cq.getQuestionContent());
            question.setType(2);*/
            answers = Lists.newArrayList();
            for (String answerString : customQuestion.getAnswerContent()){
                answers.add(GenericBuilder.of(Answer::new).with(Answer::setAnswerContent, answerString).build());
            }
            question = GenericBuilder.of(Question::new)
                    .with(Question::setMajorId, majorId)
                    .with(Question::setQuestionContent, customQuestion.getQuestionContent())
                    .with(Question::setType, 2)
                    .with(Question::setAnswers, answers)
                    .with(Question::setQuestionnaireId, questionnaireId)
                    .build();
            questions.add(question);
        }
        System.out.println(questions);
        questionMapper.batchInsert(questions);
        for (Question q : questions){
            for (Answer a : q.getAnswers()){
                a.setQuestionId(q.getId());
            }
            answerMapper.batchInsert(q.getAnswers());
        }
        //displayFormService.synchronizeDisplayForm();
        return true;
    }


    @Transactional
    private QuestionnaireModel assembleQuestionnaireModel(Integer questionnaireId, Integer grade) {

        if (questionnaireId != null && grade != null){
            Questionnaire questionnaire = questionnaireMapper.selectByPrimaryKey(questionnaireId);

            DisplayForm displayForm = displayFormMapper.selectByQuestionnaireIdAndGrade(questionnaireId, grade);
            List<Question> part1 = Lists.newArrayList();
            List<Question> part2 = Lists.newArrayList();
            int questionId = 0;
            List<Answer> answers = null;
            if (displayForm.getPart1IsDisplay()){
                part1 = questionMapper.selectByQuestionnaireIdAndType(questionnaireId, 1);
                for (Question question : part1){
                    questionId = question.getId();
                    answers = answerMapper.selectByQuestionId(questionId);
                    question.setAnswers(answers);
                }
            }
            if (displayForm.getPart2IsDisplay()){
                part2 = questionMapper.selectByQuestionnaireIdAndType(questionnaireId, 2);
                for (Question question : part2){
                    questionId = question.getId();
                    answers = answerMapper.selectByQuestionId(questionId);
                    question.setAnswers(answers);
                }
            }
            return GenericBuilder.of(QuestionnaireModel::new)
                    .with(QuestionnaireModel::setName, questionnaire.getName())
                    .with(QuestionnaireModel::setPart1, part1)
                    .with(QuestionnaireModel::setPart2, part2)
                    .build();
        }
        return null;
    }

    @Override
    public QuestionnaireModel getQuestionnaireModel(Student student){
        Integer majorId = student.getMajorId();
        Integer grade = student.getGrade();
        Major currentMajor = majorMapper.selectByPrimaryKey(majorId);
        Integer questionnaireId = currentMajor.getDisplayQuestionnaireId();
        return assembleQuestionnaireModel(questionnaireId, grade);
    }

    @Override
    public QuestionnaireModel getQuestionnaireModel(Integer questionnaireId, Integer grade){
        return assembleQuestionnaireModel(questionnaireId, grade);
    }

    @Override
    public DesignModel assembleDesignModel(Integer questionnaireId) {

        Questionnaire questionnaire = questionnaireMapper.selectByPrimaryKey(questionnaireId);

        List<Question> tempPart1 = questionMapper.selectByQuestionnaireIdAndType(questionnaireId, 1);
        List<Question> tempPart2 = questionMapper.selectByQuestionnaireIdAndType(questionnaireId, 2);

        List<String> part1 = Lists.newArrayList();
        for (Question q : tempPart1){
            part1.add(q.getQuestionContent());
        }

        List<CustomQuestion> part2 = Lists.newArrayList();
        List<String> answerContent;
        List<Answer> tempAnswers;
        for (Question q : tempPart2){
            tempAnswers = answerMapper.selectByQuestionId(q.getId());
            answerContent = Lists.newArrayList();
            for (Answer answer : tempAnswers){
                answerContent.add(answer.getAnswerContent());
            }
            part2.add(GenericBuilder.of(CustomQuestion::new).with(CustomQuestion::setQuestionContent, q.getQuestionContent()).with(CustomQuestion::setAnswerContent, answerContent).build());
        }
        return GenericBuilder.of(DesignModel::new)
                .with(DesignModel::setName, questionnaire.getName())
                .with(DesignModel::setPart1, part1)
                .with(DesignModel::setPart2, part2).build();
    }

    @Override
    @Transactional
    public boolean deleteQuestionnaireModel(Integer questionnaireId) {
        int resultCount = questionnaireMapper.deleteByPrimaryKey(questionnaireId);
        if (resultCount > 0){
            List<Integer> questionIds = questionMapper.selectIdByQuestionnaireId(questionnaireId);
            for (Integer questionId : questionIds){
                resultCount = answerMapper.deleteByQuestionId(questionId);
                if (resultCount < 0){
                    return false;
                }
            }
            resultCount = questionMapper.deleteByQuestionnaireId(questionnaireId);
            if (resultCount > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean modifyQuestionnaireModel(Integer majorId, Integer questionnaireId, String jsonString) {
        return deleteQuestionnaireModel(questionnaireId) && createQuestionnaire(majorId, jsonString, questionnaireId);
    }

    @Override
    @Transactional
    public boolean chooseQuestionnaireModel(Integer majorId, Integer questionnaireId) {
        Major major = GenericBuilder.of(Major::new)
                .with(Major::setId, majorId)
                .with(Major::setDisplayQuestionnaireId, questionnaireId)
                .build();
        int resultCount = majorMapper.updateByPrimaryKeySelective(major);
        return resultCount > 0;
    }

    @Override
    public List<SimpleQuestionnaireVo> assembleQuestionnaireVos(Integer majorId) {
        List<SimpleQuestionnaireVo> simpleQuestionnaireVos = Lists.newArrayList();
        List<Questionnaire> questionnaires = questionnaireMapper.selectByMajorId(majorId);
        for (Questionnaire q : questionnaires){
            simpleQuestionnaireVos.add(GenericBuilder.of(SimpleQuestionnaireVo::new)
                    .with(SimpleQuestionnaireVo::setId, q.getId())
                    .with(SimpleQuestionnaireVo::setName, q.getName())
                    .with(SimpleQuestionnaireVo::setUpdateTime, q.getUpdateTime())
                    .build()
            );
        }
        return simpleQuestionnaireVos;
    }
}
