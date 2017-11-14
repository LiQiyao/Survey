package edu.zust.survey.common;

import com.google.common.collect.Maps;
import edu.zust.survey.vo.QuestionnaireModel;

import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
public class QuestionnaireCache {

    private Map<Integer, QuestionnaireModel> map = Maps.newHashMap();

    public QuestionnaireCache(){
        for (int i = 1; i <= Const.MAJOR_COUNT; i++){
            map.put(i, null);
        }
    }

    public QuestionnaireModel getQuestionnaire(Integer majorId){
        return map.get(majorId);
    }

    public void putQuestionnaire(Integer majorId, QuestionnaireModel questionnaireModel){
        map.put(majorId, questionnaireModel);
    }
}
