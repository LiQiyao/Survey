package edu.zust.survey.service.impl;

import edu.zust.survey.dao.SuggestionDAO;
import edu.zust.survey.entity.Suggestion;
import edu.zust.survey.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rin
 * @Date 2017/10/20
 */
@Service
public class StatisticServiceImpl implements IStatisticService{

    @Autowired
    SuggestionDAO suggestionDAO;

    public List<Suggestion> getSuggestionList(int majorId){
        return suggestionDAO.querySuggestions(majorId);
    }
}
