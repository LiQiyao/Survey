package edu.zust.survey.entity;

public class GradeTable {
    private Integer id;

    private Integer grade;

    private Integer majorId;

    public GradeTable(Integer id, Integer grade, Integer majorId) {
        this.id = id;
        this.grade = grade;
        this.majorId = majorId;
    }

    public GradeTable() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }
}