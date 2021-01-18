package com.smart.ajax.entity;

public class SysUser {
    private Integer uid;
    private String username;
    private String password;
    private int status;

    public SysUser() {
    }

    public SysUser(Integer uid, String username, String password, int status) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
