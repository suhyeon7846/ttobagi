package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Bucketlist;

public interface BucketlistDao {
	
	int update(int cardId);

	int delete(int cardId);

	int insert(String cardTitle, String picFile);

	List<Bucketlist> getList(int id, int status);
	List<Bucketlist> getRandomList(int id);
}
