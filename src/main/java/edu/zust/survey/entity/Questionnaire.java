package edu.zust.survey.entity;

public class Questionnaire {
    private Integer id;

    private String name;

    private Integer majorId;

    private Long createTime;

    private Long updateTime;

    public Questionnaire(Integer id, String name, Integer majorId, Long createTime, Long updateTime) {
        this.id = id;
        this.name = name;
        this.majorId = majorId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Questionnaire(String name, Integer majorId, Long createTime, Long updateTime) {
        this.name = name;
        this.majorId = majorId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Questionnaire() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}