package com.ttobagi.web.controller.user;

import java.security.Principal;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttobagi.web.entity.Couple;
import com.ttobagi.web.entity.Diary;
import com.ttobagi.web.entity.DiaryView;
import com.ttobagi.web.entity.Member;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.DiaryService;
import com.ttobagi.web.service.MemberService;

@Controller
@RequestMapping("/user/diary")
public class DiaryController {
	
	@Autowired
	private DiaryService service;
	
	@Autowired
	private MemberService memberService;
	
	
	@Autowired
	private CoupleService coupleService;
	
	@GetMapping("list")
	public String list(Model model, HttpSession session,Principal principal,
			@RequestParam(name = "p", defaultValue = "1") int page ) {
		
		//세션에서 내 아이디 가져오기
		int id = (int)session.getAttribute("id");
//		String name = (String) session.getAttribute("name");
//		System.out.println("내 이름 :"+ session.getAttribute("name"));
		//내 아이디로 이름 구하기
		String name = memberService.get(id).getName();
		model.addAttribute("name",name);
		//principal로 내 이름 가져오기
		String name1 = principal.getName();
		System.out.println("내이름 : "+ name1);

		
		//-----상대방 아이디 구하기
		int opponentId=0;
		List<Couple> coupleList = coupleService.getList(id);
		if(id==coupleList.get(0).getSenderId()) {//내 아디디가 커플요청 받는자 아이디면
			opponentId =coupleList.get(0).getReceiverId();//상대방은 요청자 아이디
		}
		else if (id==coupleList.get(0).getReceiverId()) {
			opponentId =coupleList.get(0).getSenderId();//상대방은 요청자 아이디
		}
		//-----상대방 아이디로 이름 구하기
		String opponentName = memberService.get(opponentId).getName();
		
		model.addAttribute("opponentName",opponentName);
		//----- 페이지에따른 데이터 
		int size=4;
		int startIndex=size*(page-1);//0 4 8 12 16    1page면 0 2page면 4     size*(page-1)
		
		
		List<DiaryView> list = service.getViewList(id,opponentId,startIndex,size);
		model.addAttribute("list",list);
		System.out.println(list);
		return "user.diary.list";
	}
	
	@PostMapping("list")
	public String deleteAll(int[] del) {
		System.out.println(del.length);
		for(int i=0;i<del.length;i++) {
			System.out.println("삭제할 id : "+del[i]);
			}
		service.deleteAll(del);
		return "redirect:list";
	}
	
	@GetMapping("reg")
	public String reg(HttpSession session, Model model) {
		int id =(int)session.getAttribute("id");
		model.addAttribute("memberId",id);
		
		return "user.diary.reg";
	}
	
	@PostMapping("reg")
	public String regEnd(Diary diary) {
		service.insert(diary);
		System.out.println("title:"+diary.getTitle()+", content : "+diary.getContent()+", memberId : "+ diary.getMemberId()+", mood : "+ diary.getMoodId());
		return "redirect:list";
	}

}
