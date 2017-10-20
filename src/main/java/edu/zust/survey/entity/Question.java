package edu.zust.survey.entity;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 */
@Entity(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_content")
    private String questionContent;

    @Column(name = "major_id")
    private Integer majorId;

    private Integer type;

    @OneToMany(mappedBy = "question", cascade = CascadeType.MERGE, orphanRemoval = true)
    //@JoinColumn(name = "questionId")
    private List<Answer> answers = Lists.newArrayList();

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
        this.questionContent = questionContent;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionContent='" + questionContent + '\'' +
                ", majorId=" + majorId +
                ", type=" + type +
                ", answers=" + answers +
                '}';
    }

}
