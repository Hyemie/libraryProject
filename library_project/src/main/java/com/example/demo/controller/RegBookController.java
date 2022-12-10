package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.RegBookService;

import vo.RegBookVO;

@Controller
public class RegBookController {
	
	@Autowired
	private RegBookService service;
	public void setService(RegBookService service) {
		this.service = service;
	}
	
	/*일반회원 희망도서 신청하기*/
	@RequestMapping("/user_regBook")
	public String user_regBook() {
		return "user_regBook";
	}
	
	@RequestMapping("/regBook")
	public ModelAndView regBook(RegBookVO regbook) {
		ModelAndView mv = new ModelAndView();
		int result = service.addRegBook(regbook);
		mv.addObject("insertedRNum", result);
		mv.setViewName("user_regSuccess");
		return mv;
	}
	
	/*일반회원 희망도서 신청하고나서 상태 조회하기*/
	@RequestMapping("/user_regCheck")
	public ModelAndView user_regCheck() {
		ModelAndView mv = new ModelAndView("user_regCheck");
		mv.addObject("user_regCheck", service.getTotalRegBook());
		return mv;
	}
	
	/*관리자 희망도서 신청 현황 관리 조회하기*/
	@RequestMapping("/admin_regBookListBefore")
	public ModelAndView admin_regBookListBefore() {
		ModelAndView mv = new ModelAndView("admin_regBookListBefore");
		mv.addObject("admin_regBookListBefore", service.getTotalRegBook());
		return mv;
	}
	
	@RequestMapping("/admin_regBookList")
	public ModelAndView admin_regBookList() {
		ModelAndView mv = new ModelAndView("admin_regBookList");
		mv.addObject("admin_regBookList", service.getTotalRegBook());
		return mv;
	}
	
	/*RState 상태 변경*/
	   @RequestMapping(value="/updateState", method= {RequestMethod.POST})
	   public String updateState(@RequestParam ("num") String RNum , @RequestParam ("state") String RState) {
	      int num = Integer.parseInt(RNum);
	      int state = Integer.parseInt(RState);
	      System.out.println(num);
	      System.out.println(state);
	      service.updateRegBook(num, state);
	      
	      return "admin_regBookList";
	      
	   }
}
