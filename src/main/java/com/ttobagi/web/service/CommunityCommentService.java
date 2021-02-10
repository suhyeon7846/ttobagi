package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.CommunityComment;

public interface CommunityCommentService {
	List<CommunityComment> commentList(int communityId);
	int insertComment(CommunityComment communityComment);
	int deleteComment(int communityId);
	int deleteCommentAll(int communityId);
}
