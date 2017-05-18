package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.BaseMapper;
import com.example.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T>{

	@Autowired
	private BaseMapper<T> baseMapper;
	
	@Override
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insert(T t) {
		return baseMapper.insert(t);
	}

	@Override
	@Transactional
	public int insertSelective(T t) {
		return baseMapper.insertSelective(t);
	}

	@Override
	@Transactional(readOnly=true)
	public T selectByPrimaryKey(Integer id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(T t) {
		return baseMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(T t) {
		return baseMapper.updateByPrimaryKey(t);
	}

}
