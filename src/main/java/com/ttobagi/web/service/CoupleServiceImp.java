package com.ttobagi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.dao.CoupleDao;
import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.Member;

@Service
public class CoupleServiceImp implements CoupleService {

	@Autowired
	CoupleDao coupleDao;

	@Override
	public int requestCouple(int senderId, int receiverId) {
		return coupleDao.requestCouple(senderId, receiverId);
	}

	@Override
	public List<Couple> getList(int id) {
		// TODO Auto-generated method stub
		return coupleDao.getList(id);
	}
	
}
