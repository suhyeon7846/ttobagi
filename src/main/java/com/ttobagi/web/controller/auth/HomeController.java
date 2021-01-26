package com.ttobagi.web.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttobagi.web.entity.Member;
import com.ttobagi.web.entity.MemberRole;
import com.ttobagi.web.service.AuthService;

@Controller("authHomeController")
@RequestMapping("/auth/")
public class HomeController {
	
	@Autowired
	AuthService service;
	
	@GetMapping("reg")
	public String reg() {
		return "auth.reg";
	}
	
	@PostMapping("reg")
	public String reg(Member member) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		
		service.insert(member); // 회원가입 정보 insert
		
		int memberId = service.getLastId();
		int roleId = 3; // 'SOLO'
		service.insertMemberRole(memberId, roleId); 
		
		return "redirect:login";
	}
	
	@GetMapping("loginIdCheck/{loginId}")
	@ResponseBody
	public String loginIdCheck(@PathVariable(name="loginId") String loginId) {
		String isDuplication = "false";
		int result = service.checkLoginId(loginId);
		
		if (result == 1) // 중복이 된 경우
			isDuplication = "true";
		
		return isDuplication;
	}
	
	@GetMapping("nicknameCheck/{nickname}")
	@ResponseBody
	public String nicknameIdCheck(@PathVariable(name="nickname") String nickname) {
		String isDuplication = "false";
		
		int result = service.checkNickname(nickname);
		
		if (result == 1) // 중복이 된 경우
			isDuplication = "true";
		
		return isDuplication;
	}
	
	@GetMapping("login")
	public String login() {
		return "auth.login";
	}
	
}
