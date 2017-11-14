package edu.zust.survey.service;

import edu.zust.survey.entity.Student;

import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
public interface IStudentService {

    Student login(String username, String password);

    boolean answerQuestions(Integer studentId, Map<String, String[]> map);
}
