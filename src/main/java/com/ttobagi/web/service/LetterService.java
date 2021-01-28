package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Letter;

public interface LetterService {

		List<Letter> getList( int receiverId);
	
		int insert(Letter letter);
}
