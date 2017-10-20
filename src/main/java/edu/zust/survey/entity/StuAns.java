package edu.zust.survey.entity;

import javax.persistence.*;

/**
 * Created by Lee on 2017/10/19.
 */
@Entity(name = "stu_ans")
public class StuAns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id")
    private Integer studentId;


    @Column(name = "question_id")
    private Integer questionId;


    @Column(name = "answer_id")
    private Integer answerId;

    public StuAns() {
    }

    public StuAns(Integer studentId, Integer questionId, Integer answerId) {
        this.studentId = studentId;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "StuAns{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", questionId=" + questionId +
                ", answerId=" + answerId +
                '}';
    }
}
