package com.thymleaf.controller;

import com.thymleaf.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class thymleafController {

    @GetMapping("index")
    public String index(Model model)
    {
        user user=new user();
        user.setName("javasmall");user.setPassword("123456");

        Map<String,String>map=new HashMap<>();
        map.put("qq","1315426911");
        map.put("sex","man");

        List<String>list=new ArrayList<>();
        list.add("我的csdn:https://blog.csdn.net/qq_40693171");
        list.add("我的github：https://github.com/javasmall");
        list.add("我的微信公众号：欢迎关注我的个人公众号：thymleaf。");
        model.addAttribute("name","thymleaf");//字符串
        model.addAttribute("user",user);//pojo 对象
        model.addAttribute("map",map);
        model.addAttribute("list",list);
        return "index";//resources/template 下面的index.html
    }
    @GetMapping("index2")
    public ModelAndView index2()
    {
        ModelAndView view=new ModelAndView("index2");//index2.html  和jsp如出一辙
        view.addObject("name","thymleaf");
        return view;
    }
}
