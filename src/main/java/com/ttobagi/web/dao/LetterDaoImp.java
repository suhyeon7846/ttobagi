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
		return null;
	}

	@Override
	public int deleteAll(int[] del) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
