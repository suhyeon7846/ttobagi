package com.ttobagi.web.service.social;

import org.springframework.stereotype.Component;

@Component
public class KakaoOauth implements SocialOauth {

	@Override
	public String getOauthRedirectURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requestAccessToken(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requestUserInfo(String access_token) {
		// TODO Auto-generated method stub
		return null;
	}

}
