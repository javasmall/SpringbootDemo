package com.shiro.bean;

public class student {
    private String username;
    private String password;
    private String role;
    private String perm;

    public student(String username, String password, String role, String perm) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.perm = perm;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }
}
