package com.ttobagi.web.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.service.CommunityService;

@RestController("apiCommunityController")
@RequestMapping("/api/community/")
public class CommunityController {
	
	@Autowired
	private CommunityService service;
	
	@RequestMapping("{type}/{communityId}/commentInsert/{commentText}")
	public String commentInsert(
			@PathVariable("type") String type,
			@PathVariable("communityId") int communityId,
			CommunityComment communityComment,
			HttpSession session,
			@PathVariable("commentText") String commentText) {
		
		System.out.println(type);

		int id = (int)session.getAttribute("id");
		String nickname = (String)session.getAttribute("nickName");
		
		//댓글 등록
		if( commentText != null && !commentText.equals("") ) {
			communityComment.setContent(commentText);
			communityComment.setNickname(nickname);
			communityComment.setMemId(id);
			communityComment.setCommunityId(communityId);
			
			service.insertComment(communityComment);
		}

		return "ok";
	};
}
