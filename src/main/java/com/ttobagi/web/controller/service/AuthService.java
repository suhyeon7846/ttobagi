package com.ttobagi.web.controller.service;

import com.ttobagi.web.entity.Member;

public interface AuthService {

	int insert(Member member);

	int checkLoginId(String loginId);

	int checkNickname(String nickname);
}
