package edu.zust.survey.entity;

import java.util.List;

public class Question {
    private Integer id;

    private String questionContent;

    private Integer majorId;

    private Integer type;

    private Integer questionnaireId;

    private List<Answer> answers;

    public Question(Integer id, String questionContent, Integer majorId, Integer type, Integer questionnaireId) {
        this.id = id;
        this.questionContent = questionContent;
        this.majorId = majorId;
        this.type = type;
        this.questionnaireId = questionnaireId;
    }

    public Question(String questionContent, Integer majorId, Integer type, Integer questionnaireId, List<Answer> answers) {
        this.questionContent = questionContent;
        this.majorId = majorId;
        this.type = type;
        this.questionnaireId = questionnaireId;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}