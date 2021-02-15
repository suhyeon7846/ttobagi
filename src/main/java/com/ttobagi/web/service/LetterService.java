package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Letter;

public interface LetterService {

		List<Letter> getList( int receiverId);
		List<Letter> getTitleReadCheckList(int receiverId);
		
		Letter get(int id);
		
		int insert(Letter letter);

		int delete(int id);

		int deleteAll(int[] ids);
		int updateReadCheck(int id);
		

		
}
