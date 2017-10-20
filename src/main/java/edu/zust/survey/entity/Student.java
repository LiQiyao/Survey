package edu.zust.survey.entity;

import javax.persistence.*;

/**
 * Created by Lee on 2017/10/19.
 */
@Entity(name = "student")
public class Student {
    @Id
    private Integer id;

    private String username;

    private String password;

    private String name;

    @Column(name = "major_id")
    private Integer majorId;

    private String klasse;

    private Integer answered;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Suggestion suggestion;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", majorId=" + majorId +
                ", klasse='" + klasse + '\'' +
                ", answered=" + answered +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public Integer getAnswered() {
        return answered;
    }

    public void setAnswered(Integer answered) {
        this.answered = answered;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }
}
