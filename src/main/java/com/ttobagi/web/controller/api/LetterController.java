package com.ttobagi.web.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.Letter;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.LetterService;
@RestController("apiLetterController")
@RequestMapping("/api/letter/")
public class LetterController {
	
	@Autowired
	private LetterService service;
	
	@Autowired
	private CoupleService coupleService;
	
	@RequestMapping("{id}")
	public Letter detail(
	@PathVariable("id") int id) {
		
		Letter letter = service.get(id);
		System.out.println(letter.getReadCheck());
		if(letter.getReadCheck()==0)
			service.updateReadCheck(id);
		return letter;
		
	}
	
//	@PostMapping("reg")
//	public Letter reg(@RequestParam("content") String content,
//			HttpSession session) {
//		int senderId=(int) session.getAttribute("id");
//		
//		int receiverId=0;
//		List<Couple> coupleList = coupleService.getList(senderId);
//		if(senderId==coupleList.get(0).getSenderId()) {//내 아디디가 커플요청 받는자 아이디면
//			receiverId =coupleList.get(0).getReceiverId();//상대방은 요청자 아이디
//		}
//		else if (senderId==coupleList.get(0).getReceiverId()) {
//			receiverId =coupleList.get(0).getSenderId();//상대방은 요청자 아이디
//		}
//		service.insert(null)
//		return null;
//	}
}
