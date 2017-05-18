package com.example.mapper;

import java.util.List;

import com.example.pojo.Survey;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyMapper extends BaseMapper<Survey>{

	int countAll(@Param("status")String status, @Param("userId") int userId);

	List<Survey> selectAllByStatus(@Param("status")String status, @Param("userId") int userId,
			@Param("offset") int offset, @Param("limit") int limit);

}