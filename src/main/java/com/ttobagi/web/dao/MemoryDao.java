package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Memory;

public interface MemoryDao {
	
	int insert(String content, String saveFileName, int cId);
	
	List<Memory> getList(int id, int cardId);

	int delete(int cardId);

	List<Memory> keywordList(int coupleId, String text);

	List<Memory> dateList(int coupleId, String text);

	int update(int cardId, String content, String saveFileName);
	
}