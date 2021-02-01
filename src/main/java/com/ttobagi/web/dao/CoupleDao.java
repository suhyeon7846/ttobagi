package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.CoupleView;

public interface CoupleDao {

	int requestCouple(int senderId, int receiverId);

	List<Couple> getList(int id);

	Couple get(int id);

	//CoupleView isApproval(int senderId, int receiverId);

	int responseOk(int receiverId);

	int responseNo(int receiverId);

	int update(Couple origin);

	int delete(int id);

	CoupleView isApproval(int senderId, int receiverId, boolean isApproval);

}
