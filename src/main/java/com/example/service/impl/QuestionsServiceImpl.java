package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.QuestionsMapper;
import com.example.pojo.Questions;
import com.example.service.QuestionsService;

@Service
public class QuestionsServiceImpl extends BaseServiceImpl<Questions> implements
		QuestionsService {

	@Autowired
	private QuestionsMapper questionsMapper;
	
}
