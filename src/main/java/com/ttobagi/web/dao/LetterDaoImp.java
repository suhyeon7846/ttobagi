package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Session;
import com.ttobagi.web.entity.Letter;

@Repository
public class LetterDaoImp implements LetterDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Letter> getList(int senderId, int receiverId ) {
		
		return session.getMapper(LetterDao.class).getList(senderId,receiverId);
	}

	@Override
	public int insert(Letter letter) {
		
		return session.getMapper(LetterDao.class).insert(letter);
	}
	
	

}
