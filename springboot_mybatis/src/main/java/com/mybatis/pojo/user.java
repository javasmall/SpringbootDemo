package com.mybatis.pojo;

import java.util.List;

public class user {

    private String username;
    private String password;
    private List<dog> dogs;

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

    public List<dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<dog> dogs) {
        this.dogs = dogs;
    }
}
