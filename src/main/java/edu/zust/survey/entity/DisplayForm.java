package edu.zust.survey.entity;

public class DisplayForm {

    private Integer id;

    private Integer grade;

    private Integer majorId;

    private Integer questionnaireId;

    private Boolean part1IsDisplay;

    private Boolean part2IsDisplay;

    private Boolean part3IsDisplay;

    private Boolean enable;

    public DisplayForm(Integer id, Integer questionnaireId, Integer grade, Integer majorId, Boolean part1IsDisplay, Boolean part2IsDisplay, Boolean part3IsDisplay, Boolean enable) {
        this.id = id;
        this.questionnaireId = questionnaireId;
        this.grade = grade;
        this.majorId = majorId;
        this.part1IsDisplay = part1IsDisplay;
        this.part2IsDisplay = part2IsDisplay;
        this.part3IsDisplay = part3IsDisplay;
        this.enable = enable;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisplayForm that = (DisplayForm) o;

        if (questionnaireId != null ? !questionnaireId.equals(that.questionnaireId) : that.questionnaireId != null)
            return false;
        return grade != null ? grade.equals(that.grade) : that.grade == null;
    }

    @Override
    public int hashCode() {
        int result = questionnaireId != null ? questionnaireId.hashCode() : 0;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }
}