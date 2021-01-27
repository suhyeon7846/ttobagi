package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Diary;
import com.ttobagi.web.entity.Letter;

public interface LetterService {

	//-----------------------------------리스트 불러오기
		List<Letter> getList(int senderId, int receiverId);
		
		
		
		//-----------------------------------데이터 조작
		int insert(Letter letter);
//		int update(Letter letter);
//		int delete(int id);
		
		
		
		
		
		//-----------------------------------페이지 전환
//		Letter getPrev(int id);
//		Letter getNext(int id);
}
