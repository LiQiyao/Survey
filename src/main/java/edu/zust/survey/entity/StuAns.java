package edu.zust.survey.entity;

public class StuAns {
    private Integer id;

    private Integer studentId;

    private Integer questionId;

    private Integer answerId;

    public StuAns(Integer id, Integer studentId, Integer questionId, Integer answerId) {
        this.id = id;
        this.studentId = studentId;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public StuAns() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public StuAns(Integer studentId, Integer questionId, Integer answerId) {
        this.studentId = studentId;
        this.questionId = questionId;
        this.answerId = answerId;
    }
}