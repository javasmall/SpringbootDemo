package com.shiro.controller;


import com.shiro.mapper.studentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ThmleafController {

	@Autowired(required = false)
	private studentMapper studentMapper;
	
	@RequestMapping("/add")
	public String add(){
		return "/user/add";
	}
	
	@RequestMapping("/update")
	public String update(){
		return "/user/update";
	}
	
	@RequestMapping("/index")
	public String toLogin(Model model){
		model.addAttribute("name","希望能给个star谢谢！");
		return "/login";
	}
	
	@RequestMapping("/noAuth")
	public String noAuth(){
		return "/noAuth";
	}

	/**
	 * 测试thymeleaf
	 */
	@RequestMapping("/index2")
	public String testThymeleaf(Model model){
		//把数据存入model
		model.addAttribute("name", "数据渲染可看thymleaf板块");

		//返回test.html
		return "index2";
	}
	@RequestMapping("/permit")
	public String permit()
	{return "permit";}
	

}
