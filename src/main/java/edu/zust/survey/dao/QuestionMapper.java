package edu.zust.survey.dao;

import edu.zust.survey.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    int batchInsert(List<Question> questions);

    List<Question> selectByQuestionnaireId(int questionnaireId);

    List<Question> selectByQuestionnaireIdAndType(@Param("questionnaireId") int questionnaireId,@Param("type") int type);
}