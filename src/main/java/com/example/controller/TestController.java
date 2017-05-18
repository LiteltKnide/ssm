package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@RequestMapping(value="/list")
	public String showTheList(){
		
		System.out.println("this list is empty!");
		
		return "test/list";
	}
	
}
