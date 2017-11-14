package edu.zust.survey.entity;

public class Manager {
    private Integer id;

    private String username;

    private String password;

    private Integer majorId;

    public Manager(Integer id, String username, String password, Integer majorId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.majorId = majorId;
    }

    public Manager() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Manager(String username, String password, Integer majorId) {
        this.username = username;
        this.password = password;
        this.majorId = majorId;
    }
}