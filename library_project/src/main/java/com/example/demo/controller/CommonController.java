package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BookService;

@Controller
public class CommonController {

	@Autowired
	BookService service = new BookService();
	
	@RequestMapping("/main")
	public ModelAndView main(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		session.getAttribute("loginId");
		
		mv.addObject("bestBookList", service.getTotalBook());
		mv.setViewName("main");
		
		return mv;
	}
	
	
//	public String main() {
//		return "main";
//	}
	
	
	
}
