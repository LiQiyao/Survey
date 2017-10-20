package edu.zust.survey.entity;

import javax.persistence.*;

/**
 * Created by Lee on 2017/10/19.
 */
@Entity(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

/*    @Column(name = "question_id")
    private Integer questionId;*/

    @Column(name = "answer_content")
    private String answerContent;

    @Column(name = "answer_no")
    private String answerNo;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

/*    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }*/

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(String answerNo) {
        this.answerNo = answerNo;
    }

    public Answer(String answerContent) {
        this.answerContent = answerContent;
    }

    public Answer() {
    }

    public Answer(String answerContent, Question question) {
        this.answerContent = answerContent;
        this.question = question;
    }
}
