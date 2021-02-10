package com.ttobagi.web.controller.Oauth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.AuthService;
import com.ttobagi.web.service.MemberService;
import com.ttobagi.web.service.social.OauthService;
import com.ttobagi.web.social.SocialLoginType;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@CrossOrigin
@RequestMapping(value="/auth/")
@Slf4j
public class OauthController {
	@Autowired
	private OauthService oauthService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AuthService authService;
	 
    /**
     * 사용자로부터 SNS 로그인 요청을 Social Login Type 을 받아 처리
     * @param socialLoginType (GOOGLE, FACEBOOK, NAVER, KAKAO)
     */
    @GetMapping(value = "{socialLoginType}")
    @ResponseBody
    public void socialLoginType(
            @PathVariable(name = "socialLoginType") SocialLoginType socialLoginType) {
		//log.info(">> 사용자로부터 SNS 로그인 요청을 받음 :: {} Social Login", socialLoginType);
        oauthService.request(socialLoginType);
        
    }
    
	/**
     * Social Login API Server 요청에 의한 callback 을 처리
     * @param socialLoginType (GOOGLE, FACEBOOK, NAVER, KAKAO)
     * @param code API Server 로부터 넘어노는 code
     * @return SNS Login 요청 결과로 받은 Json 형태의 String 문자열 (access_token, refresh_token 등)
     */
    @GetMapping(value = "/{socialLoginType}/callback")
    public String callback(
            @PathVariable(name = "socialLoginType") SocialLoginType socialLoginType,
            @RequestParam(name = "code") String code,
            Model model) {
        //log.info(">> 소셜 로그인 API 서버로부터 받은 code :: {}", code);
    	
    	JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(oauthService.requestAccessToken(socialLoginType, code).toString());
		String access_token = element.getAsJsonObject().get("access_token").getAsString();
		
    	
    	String sub = oauthService.requestUserInfo(socialLoginType,access_token);
    	////현재위치
    	//sub
    	model.addAttribute("sub",sub);
    	
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	
    	Member m = new Member();
    	m.setName(sub);
    	m.setNickname(sub);
    	m.setLoginId(sub);
    	m.setPhone(sub);
    	m.setGender(sub);
    	m.setPassword(passwordEncoder.encode(sub));
    	
    	if(memberService.isMember(sub) == 0) {
    		memberService.socialInsert(m);
    		int memberId = authService.getLastId();
    		
    		int roleId = 3; // 'SOLO'
    		
    		authService.insertMemberRole(memberId, roleId); 
    		
    	}
    	//멤버로 등록되있는지 검사
    	// 등록 되있으면 통과
    	//등록 안되있으면 insert
    	
    	
    	return "auth.social";
    	//System.out.println(userInfo);
		 
//        Map<String, Object> params = new HashMap<>();
//        params.put("access_token", access_token);
        
        
		
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity =
//                restTemplate.postForEntity("https://www.googleapis.com/oauth2/v3/userinfo", params, String.class);
//        System.out.println(responseEntity);
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//        	return responseEntity.getBody();
//        }
        
        //return "";
    }
    
//    @GetMapping(value="/{socialLoginType}/userInfo")
//    public String userInfo(
//    		@PathVariable(name = "socialLoginType") SocialLoginType socialLoginType,
//    		@RequestParam(name = "access_token") String access_token) {
//    	
//    	System.out.println(1);
//    	return "";
//    }
}
