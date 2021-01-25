package com.ttobagi.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/diary")
public class DiaryController {
	
	@RequestMapping("list")
	public String list() {
		return "user.diary.list";
	}
	
	@RequestMapping("reg")
	public String reg() {
		return "user.diary.reg";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "user.diary.detail";
	}
}
