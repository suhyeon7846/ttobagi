package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Memory;

public interface MemoryDao {
	
	int insert(String content, String saveFileName, int cId);
	
	List<Memory> getList(int id);

	int delete(int cardId);
	
}
