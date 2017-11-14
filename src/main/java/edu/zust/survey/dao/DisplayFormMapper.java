package edu.zust.survey.dao;

import edu.zust.survey.entity.DisplayForm;
import org.apache.ibatis.annotations.Param;

public interface DisplayFormMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DisplayForm record);

    int insertSelective(DisplayForm record);

    DisplayForm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DisplayForm record);

    int updateByPrimaryKey(DisplayForm record);

    DisplayForm selectByQuestionnaireIdAndGrade(@Param("questionnaireId") int questionnaireId,@Param("grade") int grade);
}