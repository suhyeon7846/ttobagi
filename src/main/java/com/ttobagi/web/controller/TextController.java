package com.ttobagi.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemberService;

@Controller
public class TextController {
	
	@RequestMapping("/smarteditor")
	public String smartEditor() {
		return "smartEditor";
	}
	
}
