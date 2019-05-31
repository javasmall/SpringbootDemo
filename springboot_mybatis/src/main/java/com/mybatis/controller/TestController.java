package com.mybatis.controller;

import com.mybatis.dao.dogMapper;
import com.mybatis.dao.userMapper;
import com.mybatis.pojo.dog;
import com.mybatis.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired(required = false)
    private userMapper userMapper;
    @Autowired(required = false)
    private dogMapper dogMapper;

    @GetMapping("getalluser")//普通情况，假设user只有账户密码。返回的只有账户密码 dog为null
    public List<user> getalluer()
    {
        return userMapper.getalluser();
    }
    @GetMapping("getdogbyType")//一对一映射，一个狗有个主人  返回该type
    public List<dog>gedogbyType(@RequestParam(value = "type",defaultValue = "舔狗")String type)
    {
           return dogMapper.getdogbyType(type);
    }

    @GetMapping("getalluserwithdog")
    public List<user>getalluserwithdog()
    {
        return  userMapper.getalluserwithdog();
    }





}
