package com.ttobagi.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/couple/")
public class CoupleController {

	@GetMapping("reg")
	public String reg() {
		return "user.couple.reg";
	}
	
	@PostMapping("reg")
	public String reg(String temp) {
		return "redirect:";
	}
}