package com.ttobagi.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttobagi.web.entity.Letter;
import com.ttobagi.web.service.CoupleService;
import com.ttobagi.web.service.LetterService;

@Controller
@RequestMapping("/user/letter/")
public class LetterController {
	//읽은거 체크 : 읽을때 readcheck 테이블에서 편지id당 내 id를 입력해서 이미 내 id가 있는지 확인하고 있으면 읽은것임, 없으면 id 넣어주기
	//편지 읽는순간 readcheckService.inssert()
	//읽을때마다 확인? -> 비효율? 뷰로 만들어야되나-> letterView로해서 readId추가 readId==id 면 읽은거 readId!=id면 안읽은거  readId는 readcheck테이블의 읽은사람id
	//애초에 letter에 readId 넣고 만들어서 읽을때 insert한다? 현재 letter id의 readId에 내 id를 넣는다.★
	//readId==id 면 읽은거 readId ==null != id면 안읽은거
	
	
	@Autowired
	private LetterService service;
	
	@Autowired
	private CoupleService coupleService;
	
	
	@GetMapping("list")
	public String list(Model model,HttpSession session) {
		
		int id = (int)session.getAttribute("id");
		System.out.println(session.getAttribute("id"));
		List<Letter> list = service.getTitleReadCheckList(id);
		model.addAttribute("list",list);
		return "user.letter.list";
	}
	
	@PostMapping("del")
	public String delete(@RequestParam ("id") int id) {
		service.delete(id);
		return "redirect:list";
	}
	
	@PostMapping("deleteAll")
	public String deleteAll(int[] del) {
		service.deleteAll(del);
		return "redirect:list";
	}
	
	@GetMapping("reg")
	public String reg(HttpSession session, Model model) {
		int id =(int)session.getAttribute("id");
		model.addAttribute("memberId",id);
		return "user.letter.reg";
	}
	@PostMapping("reg")
	public String reg(Letter letter) {
		service.insert(letter);
		//헤더이미지, 스크린이미지 체크, 미리보기까지도 구현해야대
		return "redirect:list";
	}
	
}
