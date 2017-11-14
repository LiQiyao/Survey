package edu.zust.survey.entity;

public class Student {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private Integer majorId;

    private Integer grade;

    private String klasse;

    private Integer answered;

    public Student(Integer id, String username, String password, String name, Integer majorId, Integer grade, String klasse, Integer answered) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.majorId = majorId;
        this.grade = grade;
        this.klasse = klasse;
        this.answered = answered;
    }

    public Student() {
        super();
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
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse == null ? null : klasse.trim();
    }

    public Integer getAnswered() {
        return answered;
    }

    public void setAnswered(Integer answered) {
        this.answered = answered;
    }
}