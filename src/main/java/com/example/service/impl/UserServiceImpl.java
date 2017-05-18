package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void test(){
		System.out.println("UserService.test()");
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
	}
	
	@Override
	@Transactional(readOnly=true)
	public User isExsit(User user){
		List<User> list = userMapper.queryByUAP(user);
		if (list.size() == 0) {
			return null;
		}else{
			return list.get(0);
		}
	}

}