package com.ttobagi.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Letter;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.LetterService;

@Controller
@RequestMapping("/user/letter/")
public class LetterController {
	
	@Autowired
	private LetterService service;
	
//	@Autowired
//	private CoupleService coupleService;
	
	
	@RequestMapping("list")
	public String list(Model model) {
		//리드체크 테이블
		//
		int receiverId = 21;
		List<Letter> list = service.getList(receiverId);
		model.addAttribute("list",list);
		return "user.letter.list";
	}
	
	@RequestMapping("reg")
	public String reg() {
		return "user.letter.reg";
	}
	
}
