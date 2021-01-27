package com.ttobagi.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Letter;
import com.ttobagi.web.service.LetterService;

@Controller
@RequestMapping("/user/letter")
public class LetterController {
	
	@Autowired
	private LetterService service;
	
	
	@RequestMapping("list")
	public String list(Model model) {
		//List<Letter> list = service.getList();
		return "user.letter.list";
	}
	
	@RequestMapping("reg")
	public String reg() {
		return "user.letter.reg";
	}
	
}
