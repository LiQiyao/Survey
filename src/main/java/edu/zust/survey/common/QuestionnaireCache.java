package edu.zust.survey.common;

import com.google.common.collect.Maps;
import edu.zust.survey.service.IQuestionService;
import edu.zust.survey.vo.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
public class QuestionnaireCache {

    private Map<Integer, Questionnaire> map = Maps.newHashMap();

    public QuestionnaireCache(){
        for (int i = 1; i <= Const.MAJOR_COUNT; i++){
            map.put(i, null);
        }
    }

    public Questionnaire getQuestionnaire(Integer majorId){
        return map.get(majorId);
    }

    public void putQuestionnaire(Integer majorId, Questionnaire questionnaire){
        map.put(majorId, questionnaire);
    }
}
