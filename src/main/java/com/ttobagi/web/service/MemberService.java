package com.ttobagi.web.service;

import com.ttobagi.web.entity.Member;

public interface MemberService {

	Member getMemberByPhone(String phone);

	Member getMemberByLoginId(String loginId);

	Member get(int id);

	int update(Member member);

}
