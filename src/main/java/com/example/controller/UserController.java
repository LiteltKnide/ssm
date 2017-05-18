package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.annotations.Token;
import com.example.exceptions.UsernameAlreadyExistException;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.MD5Util;
import com.example.utils.Tools;
import com.thoughtworks.xstream.core.MapBackedDataHolder;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/query")
	public String test(){
		System.out.println("this user is NO.1");
		userService.test();
		return "test/list";
	}
	
	@RequestMapping("/login")
//	@Token(save=true)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session, Map<String, Object> map){
		
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5Util.MD5Encode32(password));
		
		User loginUser = userService.isExsit(user);
		System.out.println(loginUser);
		if (loginUser != null) {
			System.out.println("Login Success" + username + password);
			session.setAttribute(Tools.LOGIN_USER, loginUser);
			return "redirect:/survey/list/1";
		}
		map.put("msg", "用户名密码错误！");
		return "user/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Tools.LOGIN_USER);
		return "user/login";
	}
	
	@RequestMapping("/register")
	public String register(Map<String, Object> map, User user){
		
		System.out.println(user);
		user.setPassword(MD5Util.MD5Encode32(user.getPassword()));
		System.out.println(user);
		String msg = "";
		try {
			userService.insert(user);
			
			msg = "注册成功！";
			map.put("msg", msg);
			return "user/login";
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameAlreadyExistException("用户名已存在！");
		}
//		msg = "信息有误";
//		map.put("msg", msg);
//		return "user/register";
	}
	
}
