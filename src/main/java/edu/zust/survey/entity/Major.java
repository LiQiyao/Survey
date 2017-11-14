package edu.zust.survey.entity;

public class Major {
    private Integer id;

    private String majorName;

    public Major(Integer id, String majorName) {
        this.id = id;
        this.majorName = majorName;
    }

    public Major() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }
}