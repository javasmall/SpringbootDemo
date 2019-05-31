package com.redisCache.pojo;

import java.io.Serializable;

public class user  implements Serializable {
    private String name;
    private  String password;
    private  String sex;

    public user(String name,String password,String sex)
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
