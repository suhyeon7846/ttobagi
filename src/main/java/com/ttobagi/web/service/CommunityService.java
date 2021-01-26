package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityView;

public interface CommunityService {

	List<CommunityCategory> getCateList();
	List<CommunityView> getList(int id);
	List<Community> getList(int offset, int size, String field, String query);
	int insert(Community community);
	int update(Community community);
	int delete(int id);
}
