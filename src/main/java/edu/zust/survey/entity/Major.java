package edu.zust.survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Lee on 2017/10/19.
 */
@Entity(name = "major")
public class Major {
    @Id
    private Integer id;

    @Column(name = "major_name")
    private String majorName;

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
        this.majorName = majorName;
    }
}
