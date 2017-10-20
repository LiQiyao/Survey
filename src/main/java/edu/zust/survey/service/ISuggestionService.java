package edu.zust.survey.service;

import edu.zust.survey.entity.Student;

/**
 * Created by Lee on 2017/10/19.
 */
public interface ISuggestionService {
    boolean addSuggestion(Integer studentId, String suggestionContent);
}
