package com.ttobagi.web.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.CommunityComment;
import com.ttobagi.web.service.CommunityCommentService;

@RestController("apiCommunityCommentController")
@RequestMapping("/api/community/comment/")
public class CommunityCommentController {
	
	@Autowired
	private CommunityCommentService service;
	
	@RequestMapping("insert")
	public List<CommunityComment> insert(
			@RequestParam("t") String type,
			@RequestParam("cid") int communityId,
			@RequestParam("ct") String commentText,
			HttpSession session) {
		int id = (int)session.getAttribute("id");
		String nickname = (String)session.getAttribute("nickName");
		
		//댓글 등록
		CommunityComment comment = new CommunityComment();
		if( commentText != null && !commentText.equals("") ) {
			comment.setContent(commentText);
			comment.setNickname(nickname);
			comment.setMemId(id);
			comment.setCommunityId(communityId);
			
			service.insertComment(comment);
		}
		
		List<CommunityComment> commentList = service.commentList(communityId);
		return commentList;
	};
	
	@RequestMapping("del")
	public List<CommunityComment> delete(
			@RequestParam("t") String type,
			@RequestParam("cmid") int commentId,
			@RequestParam("cid") int communityId) {
		
		int result = 0;
		result = service.deleteComment(commentId);
		
		List<CommunityComment> comment = service.commentList(communityId);
		return comment;
	};
}