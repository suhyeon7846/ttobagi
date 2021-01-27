package com.ttobagi.web.dao;

import com.ttobagi.web.entity.Member;

public interface MemberDao {

	Member getMemberByPhone(String phone);

	Member getMemberByLoginId(String loginId);

}
