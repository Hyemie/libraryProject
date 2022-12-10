package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.BrBookUserDao;

import vo.BrBookUserVO;

@Component
public class BrBookUserService {

	@Autowired
	BrBookUserDao dao;
	
	public void setDao(BrBookUserDao dao) {
		this.dao = dao;
	}
	
	
	
	public int borrowBook(BrBookUserVO brBookUser) {
		return dao.insert(brBookUser);
	}
	
	public List<BrBookUserVO> selectMyBrBook(String id) {
		return dao.selectMyBrBook(id);
	}
	
	public List<BrBookUserVO> checkDuplBook(int bookNum) {
		return dao.checkDuplBook(bookNum);
	}
	
	public int existBrCheck(String id) {
		return dao.existBrCheck(id);
	}
	
}
