package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.CommunityComment;

@Repository
public class CommunityCommentDaoImp implements CommunityCommentDao {
	
	private SqlSession session;
	private CommunityCommentDao mapper;

	//생성자에서 미리 mapper 선언해둔다.
	@Autowired
	public CommunityCommentDaoImp(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(CommunityCommentDao.class);
	}
	
	@Override
	public int insertComment(CommunityComment communityComment) {
		// TODO Auto-generated method stub
		return mapper.insertComment(communityComment);
	}


	@Override
	public List<CommunityComment> commentList(int communityId) {
		// TODO Auto-generated method stub
		return mapper.commentList(communityId);
	}


	@Override
	public int deleteComment(int communityId) {
		// TODO Auto-generated method stub
		return mapper.deleteComment(communityId);
	}


	@Override
	public int deleteAllComment(int communityId) {
		// TODO Auto-generated method stub
		return mapper.deleteAllComment(communityId);
	}

}
