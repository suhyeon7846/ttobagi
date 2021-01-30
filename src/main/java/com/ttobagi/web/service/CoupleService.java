package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.CoupleView;

public interface CoupleService {

	int requestCouple(int senderId, int receiverId);

	List<Couple> getList(int id);

	Couple get(int id);

	CoupleView isApproval(int senderId, int receiverId);

	int responseOk(int receiverId);

	int responseNo(int receiverId);
}
