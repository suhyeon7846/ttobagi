package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Memory;

@Repository
public class MemoryDaoImp implements MemoryDao {

	private SqlSession session;
	private MemoryDao mapper;
	
	@Autowired
	public MemoryDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(MemoryDao.class);
	}
	
	@Override
	public int insert(String content, String saveFileName, int cId) {
		
		return mapper.insert(content, saveFileName, cId);
	}

	@Override
	public List<Memory> getList(int id,int cardId) {
		// TODO Auto-generated method stub
		return mapper.getList(id,cardId);
	}

	@Override
	public int delete(int cardId) {
		// TODO Auto-generated method stub
		return mapper.delete(cardId);
	}

	@Override
	public List<Memory> keywordList(int coupleId, String text) {
		// TODO Auto-generated method stub
		return mapper.keywordList(coupleId, text);
	}

	@Override
	public List<Memory> dateList(int coupleId, String text) {
		// TODO Auto-generated method stub
		return mapper.dateList(coupleId, text);
	}

	@Override
	public int update(int cardId, String content, String saveFileName) {
		
		return mapper.update(cardId, content, saveFileName);
	}

}
