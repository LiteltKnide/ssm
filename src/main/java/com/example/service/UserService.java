package com.example.service;

import org.springframework.stereotype.Service;

import com.example.pojo.User;

@Service
public interface UserService extends BaseService<User>{
	
	public void test();
	
	public User isExsit(User user);
}
