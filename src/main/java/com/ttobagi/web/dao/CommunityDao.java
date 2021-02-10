package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityCategory;
import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.entity.CommunityFiles;
import com.ttobagi.web.entity.CommunityView;

public interface CommunityDao {
	//community
	List<Community> getList(int offset, int size, String type, String orderSet);
	Community get(int id);
	int insert(Community community);
	int update(Community community);
	int delete(int id);	
	List<CommunityView> getViewList(int offset, int size, String type, String orderSet);
	CommunityView getView(int id);
	
	//files
	CommunityFiles getFiles(int id);
	int insertFiles(CommunityFiles communityFiles);
	int updateFiles(CommunityFiles communityFiles);
	int deleteFiles(int id);
	int getLastNum();
}
