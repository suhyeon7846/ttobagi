package com.ttobagi.web.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttobagi.web.entity.Community;
import com.ttobagi.web.entity.CommunityView;
import com.ttobagi.web.service.CommunityService;

@RestController("apiCommunityRecomController")
@RequestMapping("/api/community/recom/")
public class CommunityRecomController {
	
	@Autowired
	private CommunityService service;
	
	@RequestMapping("like")
	public CommunityView like(
			@RequestParam("t") String type,
			@RequestParam("cid") int communityId
		) {
		
		Community origin = service.get(communityId);
		origin.setRecomCnt(origin.getRecomCnt()+1);
		
		int result = 0;
		result = service.update(origin);
		
		CommunityView communityView = service.getView(communityId);
		//System.out.println(communityView);
		return communityView;
	};
	
	@RequestMapping("hate")
	public CommunityView hate(
			@RequestParam("t") String type,
			@RequestParam("cid") int communityId
		) {
		
		Community origin = service.get(communityId);
		origin.setNegativeCnt(origin.getNegativeCnt()+1);
		
		int result = 0;
		result = service.update(origin);
		
		CommunityView communityView = service.getView(communityId);
		//System.out.println(communityView);
		return communityView;
	};
}



