package edu.zust.survey.service.impl;

import edu.zust.survey.service.IStuAnsService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class StuAnsServiceImpl implements IStuAnsService{

    public boolean answerQuestions(Integer studentId, Map<String, String[]> answers) {
        return false;
    }
}
