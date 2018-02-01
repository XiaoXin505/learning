package com.javen.model;

import java.io.Serializable;

public class TbUser implements Serializable{
    private Integer userId;

    private String username;

    private String password;

    private String iphoneNo;

    private String salt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getIphoneNo() {
        return iphoneNo;
    }

    public void setIphoneNo(String iphoneNo) {
        this.iphoneNo = iphoneNo == null ? null : iphoneNo.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}