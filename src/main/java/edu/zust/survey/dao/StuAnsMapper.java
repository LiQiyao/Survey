package edu.zust.survey.dao;

import edu.zust.survey.entity.StuAns;
import edu.zust.survey.vo.AnswerSheetVo;
import edu.zust.survey.vo.QuestionAndAnswerEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuAnsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuAns record);

    int insertSelective(StuAns record);

    StuAns selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuAns record);

    int updateByPrimaryKey(StuAns record);

    int selectCountByAnswerIdAndGrade(@Param("answerId") Integer answerId,@Param("grade") Integer grade);

    List<QuestionAndAnswerEntry> selectByStudentIdAndType(@Param("studentId") Integer studentId,@Param("type") Integer part);
}