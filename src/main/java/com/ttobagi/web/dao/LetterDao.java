package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Letter;

public interface LetterDao {
	
	List<Letter> getList(int senderId, int receiverId);
	
	int insert(Letter letter);



}
