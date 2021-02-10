package com.ttobagi.web.service.social;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttobagi.web.social.SocialLoginType;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
public class OauthService {
//	@Autowired
//    private FacebookOauth facebookOauth;
//	
//	@Autowired
//    private GoogleOauth googleOauth;
//	
//	@Autowired
//    private KakaoOauth kakaoOauth;
//	
//	@Autowired
//    private NaverOauth naverOauth;
//	
//	@Autowired
//	private HttpServletResponse response;
// 
//    public void request(SocialLoginType socialLoginType) {
//        String redirectURL;
//        switch (socialLoginType) {
//            case GOOGLE: {
//                redirectURL = googleOauth.getOauthRedirectURL();
//            } break;
//            case FACEBOOK: {
//                redirectURL = facebookOauth.getOauthRedirectURL();
//            } break;
//            case KAKAO: {
//                redirectURL = kakaoOauth.getOauthRedirectURL();
//            } break;
//            case NAVER: {
//                redirectURL = naverOauth.getOauthRedirectURL();
//            } break;
//            default: {
//                throw new IllegalArgumentException("알 수 없는 소셜 로그인 형식입니다.");
//            }
//        }
//        try {
//            response.sendRedirect(redirectURL);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public String requestAccessToken(SocialLoginType socialLoginType, String code) {
//        switch (socialLoginType) {
//            case GOOGLE: {
//                return googleOauth.requestAccessToken(code);
//            }
//            case FACEBOOK: {
//                return facebookOauth.requestAccessToken(code);
//            }
//            case KAKAO: {
//                return kakaoOauth.requestAccessToken(code);
//            }
//            case NAVER: {
//                return naverOauth.requestAccessToken(code);
//            }
//            default: {
//                throw new IllegalArgumentException("알 수 없는 소셜 로그인 형식입니다.");
//            }
//        }
//    }
	@Autowired
	private List<SocialOauth> socialOauthList;
	@Autowired
    private HttpServletResponse response;
 
    public void request(SocialLoginType socialLoginType) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        String redirectURL = socialOauth.getOauthRedirectURL();
        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public String requestAccessToken(SocialLoginType socialLoginType, String code) {
        SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
        return socialOauth.requestAccessToken(code);
    }
 
    private SocialOauth findSocialOauthByType(SocialLoginType socialLoginType) {
        return socialOauthList.stream()
                .filter(x -> x.type() == socialLoginType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 SocialLoginType 입니다."));
    }

	public String requestUserInfo(SocialLoginType socialLoginType, String access_token) {
		// TODO Auto-generated method stub
		SocialOauth socialOauth = this.findSocialOauthByType(socialLoginType);
		String sub = socialOauth.requestUserInfo(access_token);
		
		return sub;
		
//		try {
//            response.sendRedirect(redirectURL);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		return socialOauth.requestUserInfo(access_token);
	}
}