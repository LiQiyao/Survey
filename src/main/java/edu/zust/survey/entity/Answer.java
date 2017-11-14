package edu.zust.survey.entity;

public class Answer {
    private Integer id;

    private Integer questionId;

    private String answerContent;

    private String answerNo;

    public Answer(Integer id, Integer questionId, String answerContent, String answerNo) {
        this.id = id;
        this.questionId = questionId;
        this.answerContent = answerContent;
        this.answerNo = answerNo;
    }

    public Answer(Integer questionId, String answerContent) {
        this.questionId = questionId;
        this.answerContent = answerContent;
    }

    public Answer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public String getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(String answerNo) {
        this.answerNo = answerNo == null ? null : answerNo.trim();
    }
}