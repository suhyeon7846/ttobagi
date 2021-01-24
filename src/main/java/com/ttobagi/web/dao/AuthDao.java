package com.ttobagi.web.dao;

import com.ttobagi.web.entity.Member;

public interface AuthDao {

	int insert(Member member);

	int checkLoginId(String loginId);

	int checkNickname(String nickname);

}
