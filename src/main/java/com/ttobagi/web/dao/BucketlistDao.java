package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Bucketlist;

public interface BucketlistDao {
	
	int update(int cardId);

	int delete(int cardId);

	int insert(String cardTitle, String picFile, int cId);

	List<Bucketlist> getList(int id, int status, int cardId);
	List<Bucketlist> getRandomList(int id);
}
