package edu.zust.survey.dao;

import edu.zust.survey.entity.Answer;

import java.util.List;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    int batchInsert(List<Answer> answers);

    List<Answer> selectByQuestionId(int questionId);
}