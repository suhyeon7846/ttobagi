package com.ttobagi.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttobagi.web.entity.Bucketlist;

@Repository
public class BucketlistDaoImp implements BucketlistDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Bucketlist> getList() {
		BucketlistDao mapper = session.getMapper(BucketlistDao.class);
		return mapper.getList();
	}

}
