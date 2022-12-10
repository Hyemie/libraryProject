package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BookService;
import com.example.demo.service.MemberService;

import vo.BookVO;
import vo.MemberVo;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	public void setService(BookService service) {
		this.service = service;
	}
	
	@Autowired
	private MemberService memService;
	public void setMemService(MemberService memService) {
		this.memService = memService;
	}

	
	@RequestMapping("/addForm")
	public String addForm() {
		return "add_form";
	}
	

	@RequestMapping("/add")
	public ModelAndView add(BookVO book) {
		ModelAndView mv = new ModelAndView();
		int result = service.addBook(book);
		mv.addObject("insertedBookNum", result);
		mv.setViewName("add_success");
		return mv;
	}
	
	@RequestMapping("/admin_bookList")
	public ModelAndView adminBookList(HttpSession session) {
		ModelAndView mv = new ModelAndView("admin_bookList");
		
		//로그인된 아이디 권한 받아오기
		String loginId = (String)session.getAttribute("loginId");
		MemberVo member = memService.selectMember(loginId);
		String loginAdmin = (String)member.getAdmin();
		mv.addObject("loginAdmin", loginAdmin);
		
		mv.addObject("admin_bookList", service.getTotalBook());
		return mv;
	}
	
//	@RequestMapping("/admin_delete")
//	public ModelAndView delete(@RequestParam("bookNum") int bookNum) {
//		ModelAndView mv = new ModelAndView();
//		
//		int result = service.deleteBook(bookNum);
//		
//		mv.addObject("admin_deleteResult", result);
//		mv.setViewName("admin_bookList");
//		return mv;
//	}
	@RequestMapping("/admin_delete")
	public String delete(@RequestParam("bookNum") int bookNum) {
		
		int result = service.deleteBook(bookNum);
			if(result == 1) {
				return "redirect:admin_bookList";
			}else {
				return"redirect:admin_bookList";
			}
	}

	@RequestMapping("/admin_updateForm")
	public ModelAndView updateForm(@RequestParam("bookNum") int bookNum) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("original", service.readBook(bookNum));
		mv.setViewName("admin_updateForm");
		return mv;
	}
	
	@RequestMapping("/admin_update")
	public ModelAndView update(BookVO book) {
		ModelAndView mv = new ModelAndView();
		int result = service.modifyBook(book);
		
		mv.addObject("updateBookNum", book.getBookNum());
		mv.addObject("updateResult", result);
		mv.setViewName("admin_update_result");
		return mv;
	}
		
}
