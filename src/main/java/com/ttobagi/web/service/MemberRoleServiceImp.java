package com.ttobagi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.MemberRoleDao;

@Service
public class MemberRoleServiceImp implements MemberRoleService {

	@Autowired
	MemberRoleDao memberRoleDao;

	@Override
	public int insert(int id, int type) {
		return memberRoleDao.insert(id, type);
	}

	@Override
	public int delete(int id, int type) {
		return memberRoleDao.delete(id, type);
	}

}
