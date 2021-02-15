package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ttobagi.web.entity.Letter;

@Repository
public class LetterDaoImp implements LetterDao{
	
	
	private SqlSession session;
	private LetterDao mapper;
	
	@Autowired
	public LetterDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(LetterDao.class);
	}
	
	@Override
	public List<Letter> getList( int receiverId ) {
		
		return mapper.getList(receiverId);
	}

	@Override
	public int insert(Letter letter) {
		
		return mapper.insert(letter);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public List<Letter> getTitelReadCheckList(int receiverId) {
		// TODO Auto-generated method stub
		return session.getMapper(LetterDao.class).getTitelReadCheckList(receiverId);
	}

	@Override
	public int deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return session.getMapper(LetterDao.class).deleteAll(ids);
	}

	@Override
	public Letter get(int id) {
		// TODO Auto-generated method stub
		return session.getMapper(LetterDao.class).get(id);
	}

	@Override
	public int updateReadCheck(int id) {
		// TODO Auto-generated method stub
		return session.getMapper(LetterDao.class).updateReadCheck(id);
	}
	
	

}
