package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityFiles;
import com.ttobagi.web.entity.CommunityView;

public interface CommunityService {

	List<CommunityCategory> getCateList();
	List<Community> getList(int offset, int size, String type, String orderSet);
	List<CommunityView> getViewList(int offset, int size, String type, String orderSet);
	Community get(int id);
	CommunityView getView(int id);
	CommunityFiles getFiles(int id);
	int insert(Community community);
	int update(Community community);
	int delete(int id);
	int insertFiles(CommunityFiles communityFiles);
	int updateFiles(CommunityFiles communityFiles);
	int deleteFiles(int id);
}
