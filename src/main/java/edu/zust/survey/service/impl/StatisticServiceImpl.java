package edu.zust.survey.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.zust.survey.common.GenericBuilder;
import edu.zust.survey.dao.*;
import edu.zust.survey.entity.*;
import edu.zust.survey.service.IStatisticService;
import edu.zust.survey.vo.SuggestionVo;
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
    private SuggestionMapper suggestionMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private DisplayFormMapper displayFormMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private StuAnsMapper stuAnsMapper;


    public List<SuggestionVo> getSuggestionVoList(int majorId){
        List<Suggestion> suggestions = suggestionMapper.selectAllByMajorId(majorId);
        List<SuggestionVo> suggestionVos = Lists.newArrayList();
        Student student = null;
        for (Suggestion s : suggestions){
            student = studentMapper.selectByPrimaryKey(s.getStudentId());
            suggestionVos.add(GenericBuilder.of(SuggestionVo::new)
                            .with(SuggestionVo::setStudentName, student.getName())
                            .with(SuggestionVo::setStudentUsername, student.getUsername())
                            .build()
            );
        }
        return suggestionVos;
    }

    public Integer getCountSum(Integer majorId, Integer grade){
        return studentMapper.selectCountSumByMajorIdAndGrade(majorId, grade);
    }

    public Integer getAnsweredCountSum(Integer majorId, Integer grade){
        return studentMapper.selectAnsweredCountSumByMajorIdAndGrade(majorId, grade);
    }

    //根据年级和问卷编号返回不同的结果集，结果集中是回答id与回答被选择次数的映射
    public Map<Integer, Integer> getStatisticResultMap(Integer questionnaireId, Integer grade) {

        DisplayForm displayForm = displayFormMapper.selectByQuestionnaireIdAndGrade(questionnaireId, grade);
        Map<Integer, Integer> resultMap = Maps.newHashMap();
        List<Question> questions = Lists.newArrayList();

        if (displayForm.getPart1IsDisplay()){
            questions.addAll(questionMapper.selectByQuestionnaireIdAndType(questionnaireId, 1));
        }
        if (displayForm.getPart2IsDisplay()){
            questions.addAll(questionMapper.selectByQuestionnaireIdAndType(questionnaireId, 2));
        }

        List<Answer> answers = Lists.newArrayList();
        for (Question q : questions){
            answers = answerMapper.selectByQuestionId(q.getId());
            for (Answer answer : answers){
                resultMap.put(answer.getId(), stuAnsMapper.selectCountByAnswerIdAndGrade(answer.getId(), grade));
            }
        }
        return resultMap;
    }
}
