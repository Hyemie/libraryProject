package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BookService;
import com.example.demo.service.BrBookUserService;
import com.example.demo.service.MemberService;

import vo.BookVO;
import vo.BrBookUserVO;
import vo.MemberVo;

@Controller
public class BrBookUserController {

	@Autowired
	BrBookUserService service;
	
	public void setService(BrBookUserService service) {
		this.service = service;
	}
	
	@Autowired
	BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Autowired
	MemberService memService;
	public void setMemService(MemberService memService) {
		this.memService = memService;
	}
	
	@RequestMapping(value="/borrowBook", method= {RequestMethod.POST})
//	public String borrowBook(BrBookUserVO brBookUser, HttpSession session, @RequestParam("Title") String Title, @RequestParam("BookNum") String BookNum) {
//		
//		String loginId = (String)session.getAttribute("loginId");
//		
//		int bookNum = Integer.parseInt(BookNum);
//		
//		brBookUser.setUrDate(new Date());
//		brBookUser.setBook_num(bookNum);
//		brBookUser.setUrTitle(Title);
//		brBookUser.setUrUser(loginId);
//		
//		
//		System.out.println(Title + "/" + bookNum);
//		service.borrowBook(brBookUser);
//		
//		return "admin_bookList";
//	}
	public ModelAndView borrowBook(BrBookUserVO brBookUser, HttpSession session, @RequestParam("Title") String Title, @RequestParam("BookNum") String BookNum) {
		//책 빌리는 메소드 : book테이블 title이랑 booknum을 가져옴...
		//로그인 아이디 가져와서 session이 loginId를 갖고올 때 null값이 아니면 member에다가 loginId를 가진 member를 찝어 갖고오고 admin 값에 집어넣어 loginAdmin 객체에 부여함
		ModelAndView mv = new ModelAndView();

		String loginId = (String)session.getAttribute("loginId");
		if(session.getAttribute("loginId") != null) {
			MemberVo member = memService.selectMember(loginId);
			mv.addObject("loginAdmin", member.getAdmin());
		}

//		int bookNum = Integer.parseInt(BookNum);
//		
//		
//		//대출이력 유무 조회
//		int ExBrCheck = service.existBrCheck(loginId);
//		
//		//잔여 권수 조회
//		BookVO bookInfo = bookService.readBook(bookNum);
//		int bookCount = bookInfo.getBookCount();
		
		
//		if(ExBrCheck > 0) { //대출이력 있음
//			
//			//대출이력 조회 (신청상태, 진행상태, 북넘버)
//			BrBookUserVO Brcheck = service.checkDuplBook(bookNum);
//			String BrUser = Brcheck.getUrUser();
//			int BrStatus = Brcheck.getUrStatus();
//			int BrProgress = Brcheck.getUrProgress();
//			String BrUserId = Brcheck.getUrUser();
			
//			System.out.println(BrStatus + "/" + BrProgress + "/" + BrUser);
			
//			if(BrStatus == 0 && BrProgress == 0 && BrBookNum == bookNum) {
//				brBookUser.setUrStatus(0);
//				brBookUser.setUrProgress(1);
//				
//				bookService.updateBookCount(bookNum,--bookCount);
//			}else {
//				System.out.println("대출불가");
//			}
			
//		} else { //대출이력 없음
//			brBookUser.setUrStatus(0);
//			brBookUser.setUrProgress(1);
//		}

		
		
		
//		brBookUser.setUrDate(new Date());
//		brBookUser.setBook_num(bookNum);
//		brBookUser.setUrTitle(Title);
//		brBookUser.setUrUser(loginId);
//		
//		service.borrowBook(brBookUser);
		
		//대출완료상태가되면 대출버튼을 예약버튼으로 전환하기 위해 신청상태,진행상태 값을 저장해서 view에서 사용 
//		mv.addObject("BrStatus",BrStatus);
//		mv.addObject("BrProgress",BrProgress);
//		mv.addObject("bookCount",bookCount);
		
		mv.setViewName("admin_bookList");
		
		
		
		return mv;
	}
	
	
	public ModelAndView myBrBookList(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		String loginId = (String)session.getAttribute("loginId");
		MemberVo member = memService.selectMember(loginId);
		mv.addObject("loginAdmin", member.getAdmin());
		
		mv.addObject("myBrBook",service.selectMyBrBook(loginId));
		
		mv.setViewName("user_brBook");
		
		return mv;
	}
	
	
}
  