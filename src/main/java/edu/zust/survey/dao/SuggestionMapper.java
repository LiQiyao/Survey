package edu.zust.survey.dao;

import edu.zust.survey.entity.Suggestion;

import java.util.List;

public interface SuggestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Suggestion record);

    int insertSelective(Suggestion record);

    Suggestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Suggestion record);

    int updateByPrimaryKey(Suggestion record);

    List<Suggestion> selectAllByMajorId(int majorId);

    String selectContentByStudentId(int studentId);
}