package edu.zust.survey.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * Created by Lee on 2017/10/19.
 */
@Entity(name = "suggestion")
public class Suggestion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

/*    @Column(name = "student_id")
    private Integer studentId;*/

    @Column(name = "suggestion_content")
    private String suggestionContent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSuggestionContent() {
        return suggestionContent;
    }

    public void setSuggestionContent(String suggestionContent) {
        this.suggestionContent = suggestionContent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
