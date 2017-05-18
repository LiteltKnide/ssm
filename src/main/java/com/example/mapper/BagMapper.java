package com.example.mapper;

import com.example.pojo.Bag;
import com.example.pojo.Questions;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BagMapper extends BaseMapper<Bag> {

	List<Bag> selectBySurveyId(@Param("surveyId")int id);

}