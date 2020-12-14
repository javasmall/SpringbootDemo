package com.restfuldemo.pojo;

public class Dog {
    private int id;//唯一id标识
    private String name;//名称
    private  int age;//年龄
    public Dog(){}
    public Dog(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
