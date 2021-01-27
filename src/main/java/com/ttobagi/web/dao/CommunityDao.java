package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityView;

public interface CommunityDao {

	List<CommunityCategory> getCateList();
	List<Community> getList(int offset, int size, String type, String orderSet);
	List<CommunityView> getViewList(int offset, int size, String type, String orderSet);
	Community get(int id);
	CommunityView getView(int id);
	int insert(Community community);
	int update(Community community);	
	int delete(int id);
}
