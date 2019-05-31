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
public class DogController {

    @Autowired(required = false)
    private dogMapper dogMapper;

    @GetMapping("getalldog")
    public List<dog> getalldog()
    {
        return dogMapper.getalldog();
    }
    @GetMapping("getdogbymaster")//不加参数默认为bigsai
    public List<dog> getalldog(@RequestParam(value = "type",defaultValue = "舔狗")String type)
    {
        return dogMapper.getdogbyType(type);
    }
}
