package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.BagMapper;
import com.example.pojo.Bag;
import com.example.service.BagService;

@Service
public class BagServiceImpl extends BaseServiceImpl<Bag> implements BagService{

	@Autowired
	private BagMapper bagMapper;

	@Override
	@Transactional
	public void insertBySeq(Bag bag) {
		
		System.out.println(bag);
		List<Bag> list = bagMapper.selectBySurveyId(bag.getSurveyId());
		if (list.size() == 0) {
			bag.setBagSeq(1);
		}else {
			int bagSeq = 1;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getBagSeq() > bagSeq) {
					bagSeq = list.get(i).getBagSeq();
				}
			}
			bag.setBagSeq(bagSeq + 1);
		}
		
		bagMapper.insertSelective(bag);
//		int i = 10/0;
	}
	
}
