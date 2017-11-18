package edu.zust.survey.vo;

import edu.zust.survey.entity.Student;

import java.util.List;

/**
 * Created by Lee on 2017/11/17.
 * 每个学生答题情况的bean
 */
public class AnswerSheetVo {

    private Student student;

    private List<QuestionAndAnswerEntry> part1;

    private List<QuestionAndAnswerEntry> part2;

    private String suggestionContent;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<QuestionAndAnswerEntry> getPart1() {
        return part1;
    }

    public void setPart1(List<QuestionAndAnswerEntry> part1) {
        this.part1 = part1;
    }

    public List<QuestionAndAnswerEntry> getPart2() {
        return part2;
    }

    public void setPart2(List<QuestionAndAnswerEntry> part2) {
        this.part2 = part2;
    }

    public String getSuggestionContent() {
        return suggestionContent;
    }

    public void setSuggestionContent(String suggestionContent) {
        this.suggestionContent = suggestionContent;
    }


}

