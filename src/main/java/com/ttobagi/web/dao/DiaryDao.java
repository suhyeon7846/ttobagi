package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Diary;
import com.ttobagi.web.entity.DiaryView;

public interface DiaryDao {
	//-----------------------------------리스트 불러오기
		List<Diary> getList();
		List<DiaryView> getViewList(int id, int opponentId,int startIndex, int size);

		
		//-----------------------------------데이터 조작
		int insert(Diary diary);
		int delete(int id);
		int deleteAll(int[] ids);
		
		
		
		
}
