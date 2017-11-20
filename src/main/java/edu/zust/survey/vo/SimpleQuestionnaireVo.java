package edu.zust.survey.vo;

/**
 * Created by Lee on 2017/11/20.
 * 在问卷目录中显示每一个问卷项
 */
public class SimpleQuestionnaireVo {
    private Integer id;

    private String name;

    private Integer majorId;

    private Long updateTime;

    private boolean display;

    @Override
    public String toString() {
        return "SimpleQuestionnaireVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", majorId=" + majorId +
                ", updateTime=" + updateTime +
                ", isDisplay=" + display +
                '}';
    }

    public SimpleQuestionnaireVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }
}
