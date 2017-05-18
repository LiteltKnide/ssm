package com.example.mapper;

import com.example.pojo.Questions;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsMapper extends BaseMapper<Questions>{

	List<Questions> selectAllByBagId(@Param("bagId")int id);


}