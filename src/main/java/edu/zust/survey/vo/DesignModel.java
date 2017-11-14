package edu.zust.survey.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2017/10/20.
 */
public class DesignModel {

    private String name;
    private List<String> part1;
    private List<CustomQuestion> part2;

    @Override
    public String toString() {
        return "DesignModel{" +
                "part1=" + part1 +
                ", part2=" + part2 +
                '}';
    }

    public List<String> getPart1() {
        return part1;
    }

    public void setPart1(List<String> part1) {
        this.part1 = part1;
    }

    public List<CustomQuestion> getPart2() {
        return part2;
    }

    public void setPart2(List<CustomQuestion> part2) {
        this.part2 = part2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public DesignModel(List<String> part1, List<CustomQuestion> part2) {
        this.part1 = part1;
        this.part2 = part2;
    }*/

    public DesignModel(String name, List<String> part1, List<CustomQuestion> part2) {
        this.name = name;
        this.part1 = part1;
        this.part2 = part2;
    }

    public DesignModel() {
    }
}
