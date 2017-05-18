package com.example.service;

import com.example.pojo.Bag;

public interface BagService extends BaseService<Bag>{

	void insertBySeq(Bag bag);

}
