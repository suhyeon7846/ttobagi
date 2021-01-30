package com.ttobagi.web.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.MemberService;

public class TtobagiAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	MemberService service;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		HttpSession session = request.getSession();
		
		if (session != null) {
			// 현재 사용자 얻기(보안 관련된 전역객체 SecurityContextHolder를 사용하자)
			User authUser = (User) SecurityContextHolder
								.getContext()
								.getAuthentication()
								.getPrincipal();
			
			String loginId = authUser.getUsername();
			
			Member member = service.getMemberByLoginId(loginId);
			
			// 세션에 필요한 정보 담기
			session.setAttribute("loginId", loginId);
			session.setAttribute("id", member.getId());
			session.setAttribute("phone", member.getPhone());
			
			Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
			
			SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			
			if (savedRequest != null) { // 고의로 url로 접근하여 걸렸을 때(로그인을 하면 해당 url로 리다이렉트 되어야 한다)
				String returnURL = savedRequest.getRedirectUrl();
				redirectStrategy.sendRedirect(request, response, returnURL);
			} else if (authorities.contains("ROLE_ADMIN")) {
				// 로그인 페이지에 의도하여 접근하고 로그인을 성공했을 때
				redirectStrategy.sendRedirect(request, response, "/admin/index");
			} else if (authorities.contains("ROLE_COUPLE") || authorities.contains("ROLE_SOLO")) {
				redirectStrategy.sendRedirect(request, response, "/index");
			} else {
				throw new IllegalStateException();
			}

		}
	}

}
