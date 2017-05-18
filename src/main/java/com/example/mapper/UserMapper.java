package com.example.mapper;

import com.example.pojo.User;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User>{
	
    List<User> queryByUAP(User user);
}