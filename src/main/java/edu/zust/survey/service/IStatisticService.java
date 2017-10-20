package edu.zust.survey.service;

import edu.zust.survey.entity.Suggestion;

import java.util.List;
import java.util.Map;

/**
 * @Author Rin
 * @Date 2017/10/20
 */
public interface IStatisticService {
    List<Suggestion> getSuggestionList(int majorId);
    Integer getCountSum(Integer majorId);
    Integer getAnsweredCountSum(Integer majorId);
    Map<Integer, Integer> getResultMap(Integer majorId);
}
