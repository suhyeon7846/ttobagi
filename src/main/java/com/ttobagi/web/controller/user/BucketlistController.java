package com.ttobagi.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttobagi.web.entity.Bucketlist;
import com.ttobagi.web.service.BucketlistService;

@Controller
@RequestMapping("/user/bucketlist")
public class BucketlistController {
	
	@Autowired
	private BucketlistService service;
	
	@RequestMapping("list")
	public String list(Model model){
		
		List<Bucketlist> list =service.getList();
		
		model.addAttribute("list", list);
		return "user.bucketlist.list";
	}
}
