package com.elasticsearch.pojo;

public class dog {
    private  String name;
    private  String type;
    private  int age;
    private  String details;//介绍


    public dog(String name, String type, int age,String details) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.details=details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
