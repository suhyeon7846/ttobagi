package com.ttobagi.web.dao;

import java.util.List;

import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.entity.MemberView;

public interface MemberDao {

	Member getMemberByPhone(String phone);

	Member getMemberByLoginId(String loginId);

	Member get(int id);

	int update(Member member);

	List<MemberView> getViewList(int offset, int size, String search, int rowNum);

	List<Member> getList(int offset, int size, String search);

	int getCount(String search);

	int getCoupleCount();

	int getSingleCount();

	int getWaitCount();

	int isMember(String sub);

	int socialInsert(Member m);

}
