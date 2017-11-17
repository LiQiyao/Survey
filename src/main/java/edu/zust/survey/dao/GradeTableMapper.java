package edu.zust.survey.dao;

import edu.zust.survey.entity.GradeTable;

import java.util.List;

public interface GradeTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GradeTable record);

    int insertSelective(GradeTable record);

    GradeTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GradeTable record);

    int updateByPrimaryKey(GradeTable record);

    List<Integer> selectAllGrade();
}