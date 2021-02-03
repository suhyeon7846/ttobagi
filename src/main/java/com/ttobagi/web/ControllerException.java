package com.ttobagi.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerException {

//	@ExceptionHandler(IndexOutOfBoundsException.class)
//	@ResponseBody
//	public String bound(Exception e) {
//		// 귀찮아서 @ResponseBody쓴거고 페이지를 출력할 때는 @ResponseBody 빼고 해야 한다.
//		return "bound error";
//	}

	@ExceptionHandler(Exception.class)
	public String error(Exception e, Model model) {

		model.addAttribute("message", e.getMessage());
		
		return "error";
	}
}