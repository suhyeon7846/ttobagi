package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.DiaryDao;
import com.ttobagi.web.entity.Diary;
import com.ttobagi.web.entity.DiaryView;


@Service
public class DiaryServiceImp implements DiaryService{

	@Autowired
	private DiaryDao diaryDao;
	
	
	@Override
	public List<Diary> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<DiaryView> getViewList(int id, int opponentId,int startIndex, int size) {
		// TODO Auto-generated method stub
		return diaryDao.getViewList(id, opponentId,startIndex, size);
	}

	@Override
	public int insert(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Diary getPrev(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary getNext(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
