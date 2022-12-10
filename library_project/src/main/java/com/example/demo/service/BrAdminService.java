package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.BrAdminDao;

import vo.BrAdminVO;

@Component
public class BrAdminService {
	
	@Autowired
	private BrAdminDao dao;
	
	//세션에 저장할 때 필요한 BrName 가져오기
	public BrAdminVO getBrNum(int BrNum) {
		return dao.select(BrNum);
	}
	
	//대출 메소드
	public boolean borrow(int BrNum, @Param("id") String id) {
		if(dao.borrowBook(BrNum) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<BrAdminVO> getTotalList(){
		return dao.selectAdminList();
	}
	
	public int addList(BrAdminVO adminlist) {
		dao.insert(adminlist);
		return adminlist.getBrNum();
	}
	
}
