package edu.zust.survey.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by Lee on 2017/11/20.
 * 为每个年级选择问卷的Vo
 */
public class GradeChoiceVo {

    private Integer grade;

    private Integer currentQuestionnaireIdChoice;

    private List<IdAndNameVo> questionnaires;

    private Boolean part1IsDisplay;

    private Boolean part2IsDisplay;

    private Boolean part3IsDisplay;

    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Integer getCurrentQuestionnaireIdChoice() {
        return currentQuestionnaireIdChoice;
    }

    public void setCurrentQuestionnaireIdChoice(Integer currentQuestionnaireIdChoice) {
        this.currentQuestionnaireIdChoice = currentQuestionnaireIdChoice;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public List<IdAndNameVo> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<IdAndNameVo> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public Boolean getPart1IsDisplay() {
        return part1IsDisplay;
    }

    public void setPart1IsDisplay(Boolean part1IsDisplay) {
        this.part1IsDisplay = part1IsDisplay;
    }

    public Boolean getPart2IsDisplay() {
        return part2IsDisplay;
    }

    public void setPart2IsDisplay(Boolean part2IsDisplay) {
        this.part2IsDisplay = part2IsDisplay;
    }

    public Boolean getPart3IsDisplay() {
        return part3IsDisplay;
    }

    public void setPart3IsDisplay(Boolean part3IsDisplay) {
        this.part3IsDisplay = part3IsDisplay;
    }
}
