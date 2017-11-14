package edu.zust.survey.entity;

public class Major {
    private Integer id;

    private String majorName;

    private Integer displayQuestionnaireId;

    public Major(Integer id, String majorName, Integer displayQuestionnaireId) {
        this.id = id;
        this.majorName = majorName;
        this.displayQuestionnaireId = displayQuestionnaireId;
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

    public Integer getDisplayQuestionnaireId() {
        return displayQuestionnaireId;
    }

    public void setDisplayQuestionnaireId(Integer displayQuestionnaireId) {
        this.displayQuestionnaireId = displayQuestionnaireId;
    }
}