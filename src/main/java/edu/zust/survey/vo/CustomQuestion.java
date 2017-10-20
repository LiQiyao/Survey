package edu.zust.survey.vo;

import java.util.List;

/**
 * Created by Lee on 2017/10/20.
 */
public class CustomQuestion {

    private String questionContent;
    private List<String> answerContent;

    @Override
    public String toString() {
        return "CustomQuestion{" +
                "questionContent='" + questionContent + '\'' +
                ", answerContent=" + answerContent +
                '}';
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<String> getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(List<String> answerContent) {
        this.answerContent = answerContent;
    }

    public CustomQuestion(String questionContent, List<String> answerContent) {
        this.questionContent = questionContent;
        this.answerContent = answerContent;
    }

    public CustomQuestion() {
    }
}
