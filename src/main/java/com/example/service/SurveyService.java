package com.example.service;

import java.util.Map;

import com.example.pojo.Page;
import com.example.pojo.Survey;

public interface SurveyService extends BaseService<Survey>{

	Page<Survey> getPage(String status, String nowPage, int userId);

	Survey selectAllBySurvey(int id);

}
