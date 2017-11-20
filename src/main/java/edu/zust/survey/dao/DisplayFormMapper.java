package edu.zust.survey.dao;

import edu.zust.survey.entity.DisplayForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisplayFormMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DisplayForm record);

    int insertSelective(DisplayForm record);

    DisplayForm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DisplayForm record);

    int updateByPrimaryKey(DisplayForm record);

    DisplayForm selectByQuestionnaireIdAndGrade(@Param("questionnaireId") int questionnaireId,@Param("grade") int grade);

    List<DisplayForm> selectByMajorId(Integer majorId);

    List<DisplayForm> selectAll();

    List<DisplayForm> selectByQuestionnaireId(Integer questionnaireId);

    int updateByMajorIdAndGrade(DisplayForm displayForm);

    Integer selectByMajorIdAndGrade(@Param("majorId") int majorId,@Param("grade") int grade);
}