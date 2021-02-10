package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.CommunityCommentDao;
import com.ttobagi.web.entity.CommunityComment;
@Service
public class CommunityCommentServiceImp implements CommunityCommentService {

	@Autowired
	private CommunityCommentDao communityCommentDao; 
	
	@Override
	public int insertComment(CommunityComment communityComment) {
		// TODO Auto-generated method stub
		return communityCommentDao.insertComment(communityComment);
	}

	@Override
	public List<CommunityComment> commentList(int communityId) {
		// TODO Auto-generated method stub
		return communityCommentDao.commentList(communityId);
	}

	@Override
	public int deleteComment(int communityId) {
		// TODO Auto-generated method stub
		return communityCommentDao.deleteComment(communityId);
	}

	@Override
	public int deleteCommentAll(int communityId) {
		// TODO Auto-generated method stub
		return communityCommentDao.deleteAllComment(communityId);
	}
}
