package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.MemoryDao;
import com.ttobagi.web.entity.Memory;

@Service
public class MemoryServiceImp implements MemoryService {

	@Autowired
	private MemoryDao memoryDao;
	
	@Override
	public List<Memory> getList(int id) {
		
		return memoryDao.getList(id);
	}

	@Override
	public int insert(String content, String saveFileName, int cId) {
		return memoryDao.insert(content, saveFileName, cId);
	}

	@Override
	public int delete(int cardId) {
		// TODO Auto-generated method stub
		return memoryDao.delete(cardId);
	}

	@Override
	public List<Memory> keywordList(int coupleId, String text) {
		// TODO Auto-generated method stub
		return memoryDao.keywordList(coupleId, text);
	}

	@Override
	public List<Memory> dateList(int coupleId, String text) {
		// TODO Auto-generated method stub
		return memoryDao.dateList(coupleId,text);
	}

}
