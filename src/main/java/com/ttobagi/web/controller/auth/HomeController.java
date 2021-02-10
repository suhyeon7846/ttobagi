package com.ttobagi.web.controller.auth;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.AuthService;
import com.ttobagi.web.service.EmailService;
import com.ttobagi.web.service.EmailServiceImpl;
import com.ttobagi.web.service.MemberService;

@Controller("authHomeController")
@RequestMapping("/auth/")
public class HomeController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	EmailService emailService;
	
	public String numberGen(int len, int dupCd ) {
        
        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수
        
        for(int i=0;i<len;i++) {
            
            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));
            
            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
        return numStr;
    }

	
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
	
	@PostMapping("login/validate")
	@ResponseBody
	public String loginValidate(@RequestBody String data) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(data);
		String loginId = element.getAsJsonObject().get("loginId").getAsString();
		String password = element.getAsJsonObject().get("password").getAsString();
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Member member = memberService.getMemberByLoginId(loginId);
		
		if (member == null)
			return null;
		
		if (!passwordEncoder.matches(password,member.getPassword()))
			return null;
		else
			return "true";
	}
	
	@GetMapping("find")
	public String find() {
		return "auth.find";
	}
	
	@GetMapping("pwd/find") 
	@ResponseBody
	public String findPwd(String loginId, String email) {
		Member member = memberService.getMemberByLoginId(loginId);
		System.out.println(member);
		if (member == null)
			return null;
		
		if (email.equals(member.getEmail()))
			return "true";
		
		return null;
	}
	
	@GetMapping("emailAuth")
	@ResponseBody
	public String emailAuth(String email) {
		String authNum = numberGen(6,2);
		String from = "ttobagi000@gmail.com";
		String to = email;
		String title = "TTOBAGI 이메일 인증입니다.";
		String body = "인증번호는 "+ authNum + " 입니다. 인증번호는 공개하지마세요.";
		
		emailService.send(from, to, title, body);
		
		return authNum;
	}
	
	@GetMapping("pwd/change")
	public String pwdChange(String loginId, Model model) {
		model.addAttribute("loginId", loginId);
		return "auth.change";
	}
	
	@PostMapping("pwd/change")
	public String findChange(HttpSession session, Member member) {
		if (session != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			Member origin = memberService.getMemberByLoginId(member.getLoginId());
			origin.setPassword(passwordEncoder.encode(member.getPassword()));
			
			memberService.update(origin);
		}
		
		return "redirect:/auth/login";
	}
	
}
