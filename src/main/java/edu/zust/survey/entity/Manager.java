package edu.zust.survey.entity;

import javax.persistence.*;

/**
 * Created by Lee on 2017/10/19.
 */
@Entity(name = "manager")
public class Manager {

    @Id
    private int id;

    private String username;

    private String password;

    @Column(name = "major_id")
    private int majorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public Manager() {
    }

    public Manager(String username, String password, int majorId) {
        this.username = username;
        this.password = password;
        this.majorId = majorId;
    }
}
