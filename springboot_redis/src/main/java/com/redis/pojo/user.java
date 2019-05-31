package com.redis.pojo;

import java.io.Serializable;

public class user  implements Serializable {

    //private static final Long
    private String name;
    private  String password;
    private  String sex;

    public user(){}
    @Override
    public String toString() {
        return "name:"+name+" password"+password+" sex"+sex;
    }

    public user(String name, String password, String sex)
    {
        this.name=name;
        this.password=password;
        this.sex=sex;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
