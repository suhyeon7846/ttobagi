package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Diary;
import com.ttobagi.web.entity.DiaryView;


@Repository
public class DiaryDaoImp implements DiaryDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Diary> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<DiaryView> getViewList(int id, int opponentId,int startIndex, int size) {
		// TODO Auto-generated method stub
		return session.getMapper(DiaryDao.class).getViewList(id, opponentId,startIndex,size);
	}

	@Override
	public int insert(Diary diary) {
		// TODO Auto-generated method stub
		return session.getMapper(DiaryDao.class).insert(diary);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return session.getMapper(DiaryDao.class).deleteAll(ids);
	}

}
