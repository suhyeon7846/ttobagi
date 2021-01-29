package com.ttobagi.web.service;

import java.util.List;

import com.ttobagi.web.entity.Couple;

public interface CoupleService {

	int requestCouple(int senderId, int receiverId);

	List<Couple> getList(int id);


}
