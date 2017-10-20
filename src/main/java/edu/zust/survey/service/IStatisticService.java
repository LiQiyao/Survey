package edu.zust.survey.service;

import edu.zust.survey.entity.Suggestion;

import java.util.List;

/**
 * @Author Rin
 * @Date 2017/10/20
 */
public interface IStatisticService {
    List<Suggestion> getSuggestionList(int majorId);
}
