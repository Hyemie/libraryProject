package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.MemberService;

import vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "join_form";
	}

	
	@RequestMapping("/join")
	public ModelAndView join(MemberVo member, @Param("id") String id) {
		ModelAndView mv = new ModelAndView();
		if(service.join(member)) {
			member = service.selectMember(id);
			mv.addObject("memberInfo", member);
			mv.setViewName("join_success");
		} else {
			mv.setViewName("join_fail");
		}
		
		return mv;
	}
	
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login_form";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("id")String id, @RequestParam("password")String password, HttpSession session) {
		
		if(service.login(id, password)) {
			session.setAttribute("loginId", id);
			return "login_success";
		} else {
			return "login_fail";
		}
	}
	
	@RequestMapping("/myPage")
	public ModelAndView myPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String loginId = (String)session.getAttribute("loginId");
		
		if(loginId != null && loginId.length() > 0) {
			MemberVo member = service.selectMember(loginId);
			mv.addObject("memberInfo", member);
			mv.setViewName("my_page");
		}else {
			System.out.println("로그인정보 없음");
		}
		
		return mv;
		
	}
	
	
	@RequestMapping("/updateUserForm")
	public ModelAndView updateUserForm(MemberVo member, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		member = service.selectMember(loginId);
		
		ModelAndView mv = new ModelAndView();

		mv.addObject("original", member);
		mv.setViewName("update_user_form");
		
		return mv;
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public ModelAndView updateUser(MemberVo member, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		boolean result = service.updateUser(member, loginId);
		
		ModelAndView mv = new ModelAndView();
		
		if(result) {
			mv.setViewName("update_user_success");
		}else {
			mv.setViewName("update_user_fail");
		}
		
		return mv;
	}
	
	
	@RequestMapping("/deleteUser")
//	public ModelAndView deleteUser(String id, HttpSession session) throws Exception {
//		ModelAndView mv = new ModelAndView();
//
//		String loginId = (String)session.getAttribute("loginId");
//		MemberDao dao = session.getAttribute("")
//		MemberVo member = dao.selectMember(loginId);
//		session.invalidate();
//		int result = service.deleteUser(member.getId());
//		mv.addObject("result", result);
//		mv.setViewName("delete_user_result");
//		
//		return mv;
//	}
	public String deleteUser(String id, HttpSession session) throws Exception {
		session.invalidate();
		service.deleteUser(id);
		
		return "delete_success";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "main";
	}
	
}
