package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.Bag;
import com.example.service.BagService;

@Controller
@RequestMapping("/bag")
public class BagController {
	
	@Autowired
	private BagService bagService;
	
	@RequestMapping("/add")
	public String addBag(Bag bag){
		
		bagService.insertBySeq(bag);
		
		return "redirect:/survey/toEdit/"+bag.getSurveyId();
	}
}
