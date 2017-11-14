package edu.zust.survey.entity;

public class Suggestion {
    private Integer id;

    private Integer studentId;

    private String suggestionContent;

    public Suggestion(Integer id, Integer studentId, String suggestionContent) {
        this.id = id;
        this.studentId = studentId;
        this.suggestionContent = suggestionContent;
    }

    public Suggestion() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getSuggestionContent() {
        return suggestionContent;
    }

    public void setSuggestionContent(String suggestionContent) {
        this.suggestionContent = suggestionContent == null ? null : suggestionContent.trim();
    }

    public Suggestion(Integer studentId, String suggestionContent) {
        this.studentId = studentId;
        this.suggestionContent = suggestionContent;
    }
}