package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Couple;

public interface CoupleDao {

	int requestCouple(int senderId, int receiverId);

	List<Couple> getList(int id);

}
