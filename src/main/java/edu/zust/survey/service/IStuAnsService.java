package edu.zust.survey.service;

import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
public interface IStuAnsService {
    boolean answerQuestions(Integer studentId, Map<String, String[]> map);

}
