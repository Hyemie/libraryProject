package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BrAdminService;
import com.example.demo.service.MemberService;

import vo.BrAdminVO;
import vo.MemberVo;

@Controller
public class BrAdminController {
	
	@Autowired
	private BrAdminService service;
	public void setService(BrAdminService service) {
		this.service = service;
	}
	
	@Autowired
	private MemberService memService;
	public void setMemService(MemberService memService) {
		this.memService = memService;
	}
	
	//insert
	@RequestMapping("/insert")
	public ModelAndView insert(BrAdminVO adminlist) {
		ModelAndView mv = new ModelAndView();
		int result = service.addList(adminlist);
		mv.addObject("insertedBrList", result);
		return mv;
	}
	
	//session에서 name값 가져오기
	@RequestMapping("/bringSession")
	public ModelAndView bringSession(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String BrName = (String)session.getAttribute("UrUser");
		String BrTitle = (String)session.getAttribute("UrTitle");
		String BrDate = (String)session.getAttribute("UrDate");
		
		BrAdminVO adminlist = (BrAdminVO)service.getTotalList();
		System.out.println(BrName);
		System.out.println(BrTitle);
		System.out.println(BrDate);
		
		mv.addObject("UrInfo", adminlist);
		mv.setViewName("borrowList");
		return mv;
	}
	
	//session에서 id 값으로 나머지 가져오기
//	@RequestMapping("/bringLoginId")
//	public ModelAndView bringLoginId(HttpSession session, BrAdminVO adminlist, @RequestParam("id") String id {
//		ModelAndView mv = new ModelAndView();
//		
//		String BrName = (String)session.getId();
//	}
//	
	//관리자만 대출목록 접근 가능하도록 하기
	@RequestMapping("/admin_access")
	public ModelAndView admin_access(HttpSession session, @RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("admin_access");
		
		String loginId = (String)session.getAttribute("loginId");
		MemberVo member = memService.selectMember(loginId);
		String loginAdmin = (String)member.getAdmin();
		mv.addObject("loginAdmin", loginAdmin);
		mv.addObject("admin_access", service.getTotalList());
		return mv;
	}
	
	//list
	@RequestMapping("/borrowList")
	  public ModelAndView borrowList() {
		   ModelAndView mv = new ModelAndView("borrowList");
		   mv.addObject("borrowList", service.getTotalList());
		   return mv;
	}
	
}
