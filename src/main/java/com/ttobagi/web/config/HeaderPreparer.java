package com.ttobagi.web.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.CoupleView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.MemberService;

public class HeaderPreparer implements ViewPreparer {

	@Autowired
	MemberService memberService;

	@Autowired
	CoupleService coupleService;

	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		// tiles에서 공통적으로 사용하는 것들 > context로 저장
		Map<String, Object> model = tilesContext.getContext("request");
		
		// 세션
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();

		if (session.getAttribute("id") != null) {
			int id = (int) session.getAttribute("id");
			Member member = memberService.get(id);
			
			if (member.getLoginId().equals("admin"))
				model.put("isAdmin", true);
			else
				model.put("isAdmin", false);
			
			Couple couple = coupleService.get(id);
			CoupleView coupleView = null;

			if (couple == null) {
				model.put("notification", false);
				model.put("member", member);
			} else {
				if (id == couple.getSenderId()) // 사용자가 sender인 경우
					model.put("notification", false);
				else {
					int senderId = couple.getSenderId();
					coupleView = coupleService.isApproval(senderId, 0, false);

					if (coupleView != null) { // 응답을 하지 않았으므로 새로운 알림 존재
						model.put("notification", true);
						model.put("coupleView", coupleView);
					} else // 이미 커플이므로 새로운 알림 없음
						model.put("notification", false);
				}
					
			}
		}
		
	}

}
