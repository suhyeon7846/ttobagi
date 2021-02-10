package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.entity.CommunityFiles;
import com.ttobagi.web.entity.CommunityView;

public interface CommunityCommentDao {
	int insertComment(CommunityComment communityComment);
	List<CommunityComment> commentList(int communityId);
	int deleteComment(int communityId);
	int deleteAllComment(int communityId);
}
