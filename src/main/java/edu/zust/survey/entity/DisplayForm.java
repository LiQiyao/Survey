package edu.zust.survey.entity;

public class DisplayForm {
    private Integer id;

    private Integer questionnaireId;

    private Integer grade;

    private Boolean part1IsDisplay;

    private Boolean part2IsDisplay;

    private Boolean part3IsDisplay;

    public DisplayForm(Integer id, Integer questionnaireId, Integer grade, Boolean part1IsDisplay, Boolean part2IsDisplay, Boolean part3IsDisplay) {
        this.id = id;
        this.questionnaireId = questionnaireId;
        this.grade = grade;
        this.part1IsDisplay = part1IsDisplay;
        this.part2IsDisplay = part2IsDisplay;
        this.part3IsDisplay = part3IsDisplay;
    }

    public DisplayForm() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Boolean getPart1IsDisplay() {
        return part1IsDisplay;
    }

    public void setPart1IsDisplay(Boolean part1IsDisplay) {
        this.part1IsDisplay = part1IsDisplay;
    }

    public Boolean getPart2IsDisplay() {
        return part2IsDisplay;
    }

    public void setPart2IsDisplay(Boolean part2IsDisplay) {
        this.part2IsDisplay = part2IsDisplay;
    }

    public Boolean getPart3IsDisplay() {
        return part3IsDisplay;
    }

    public void setPart3IsDisplay(Boolean part3IsDisplay) {
        this.part3IsDisplay = part3IsDisplay;
    }
}