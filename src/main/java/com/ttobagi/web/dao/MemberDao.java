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

	List<CoupleView> getViewList(int offset, int size, String search);

	List<MemberView> getList(int offset, int size, String search);

}
