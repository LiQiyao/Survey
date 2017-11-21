package edu.zust.survey.dao;

import edu.zust.survey.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int selectCountSumByMajorIdAndGrade(@Param("majorId") int majorId, @Param("grade") int grade);

    int selectAnsweredCountSumByMajorIdAndGrade(@Param("majorId") int majorId, @Param("grade") int grade);

    List<Integer> selectAllIdByMajorIdAndGrade(@Param("majorId") int majorId,@Param("grade") int grade);

    List<Student> selectAllByMajorIdAndGrade(@Param("majorId") int majorId,@Param("grade") int grade);

    int batchInsert(List<Student> students);
}