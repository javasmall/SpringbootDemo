package com.druid.pojo;

public class dog {
    private String dogname;
    private  String dogtype;
    private user master;


    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    public String getDogtype() {
        return dogtype;
    }

    public void setDogtype(String dogtype) {
        this.dogtype = dogtype;
    }

    public user getMaster() {
        return master;
    }

    public void setMaster(user master) {
        this.master = master;
    }
}
