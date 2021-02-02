package com.ttobagi.web.controller.auth;

import javax.servlet.http.HttpSession;

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
import com.ttobagi.web.service.MemberService;

@Controller("authHomeController")
@RequestMapping("/auth/")
public class HomeController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("reg")
	public String reg() {
		return "auth.reg";
	}
	
	@PostMapping("reg")
	public String reg(Member member) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		
		authService.insert(member); // 회원가입 정보 insert
		
		int memberId = authService.getLastId();
		int roleId = 3; // 'SOLO'
		authService.insertMemberRole(memberId, roleId); 
		
		return "redirect:login";
	}
	
	@GetMapping("loginIdCheck/{loginId}")
	@ResponseBody
	public String loginIdCheck(@PathVariable(name="loginId") String loginId) {
		String isDuplication = "false";
		int result = authService.checkLoginId(loginId);
		
		if (result == 1) // 중복이 된 경우
			isDuplication = "true";
		
		return isDuplication;
	}
	
	@GetMapping("nicknameCheck/{nickname}")
	@ResponseBody
	public String nicknameIdCheck(@PathVariable(name="nickname") String nickname) {
		String isDuplication = "false";
		
		int result = authService.checkNickname(nickname);
		
		if (result == 1) // 중복이 된 경우
			isDuplication = "true";
		
		return isDuplication;
	}
	
	@GetMapping("login")
	public String login() {
		return "auth.login";
	}
	
	@PostMapping("login")
	@ResponseBody
	public String loginValidate(HttpSession session, String loginId, String password) {
		String isValidate = "false";
		
		System.out.println("loginId: " + loginId);
		System.out.println("password: " + password);
		
		if (session != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			int id = (int)session.getAttribute("id");
			
			Member member = memberService.get(id);
			
			if (loginId.equals(member.getLoginId()))
				isValidate = "true";
			
			if (passwordEncoder.encode(password).equals(member.getPassword()))
				isValidate = "true";
		}
		
		return isValidate;
	}
	
}
