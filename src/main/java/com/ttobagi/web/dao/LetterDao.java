package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Letter;

public interface LetterDao {
	
	List<Letter> getList( int receiverId);
	
	int insert(Letter letter);

	int delete(int id);

	List<Letter> getTitelReadCheckList(int receiverId);

	int deleteAll(int[] ids);

	Letter get(int id);

	int updateReadCheck(int id);

	



}
