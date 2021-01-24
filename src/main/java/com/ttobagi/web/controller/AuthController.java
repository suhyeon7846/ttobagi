package com.ttobagi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.AuthService;

@Controller
@RequestMapping("/auth/")
public class AuthController {
	
	@Autowired
	AuthService service;

	@GetMapping("reg")
	public String reg() {
		return "auth.reg";
	}
	
	@PostMapping("reg")
	public String reg(Member member) {
		//MemberRole role = new MemberRole();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		//member.setRole("SOLO");
		//member.setRoles(Arrays.asList(role));
		//memberRepository.save(member);
		
		service.insert(member);
		
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
	
	@PostMapping("login")
	public String login(Member member) {
		return "redirect:"; // 일반적인 로그인 성공 시 메인으로, 시큐리티에 의해 로그인할 경우 성공 시 해당 페이지로
	}
}
