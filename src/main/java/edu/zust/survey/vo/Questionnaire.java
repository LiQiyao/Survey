package edu.zust.survey.vo;

import edu.zust.survey.entity.Question;

import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 */
public class Questionnaire {
    private List<Question> part1;
    private List<Question> part2;

    @Override
    public String toString() {
        return "Questionnaire{" +
                "part1=" + part1 +
                ", part2=" + part2 +
                '}';
    }

    public List<Question> getPart1() {
        return part1;
    }

    public void setPart1(List<Question> part1) {
        this.part1 = part1;
    }

    public List<Question> getPart2() {
        return part2;
    }

    public void setPart2(List<Question> part2) {
        this.part2 = part2;
    }

    public Questionnaire(List<Question> part1, List<Question> part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public Questionnaire() {
    }
}
