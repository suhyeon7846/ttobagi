package com.ttobagi.web.service;

import com.ttobagi.web.entity.Member;

public interface MemberService {

	Member getMemberByPhone(String phone);

	Member getMemberByLoginId(String loginId);

}
