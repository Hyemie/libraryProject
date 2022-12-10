package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.RegBookDao;

import vo.RegBookVO;

@Component
public class RegBookService {
	
	@Autowired
	private RegBookDao dao;
	
	public void setDao(RegBookDao dao) {
		this.dao = dao;
	}
	
	public int addRegBook(RegBookVO regbook) {
		dao.Reginsert(regbook);
		return regbook.getRNum();
	}
	
	public List<RegBookVO> getTotalRegBook(){
		return dao.selectBookList();
	}
	
	public RegBookVO readRegBook(int RNum, int RState) {
		return dao.selectBook(RNum, RState);
	}
	
	public int updateRegBook(int RNum, int RState) {
		return dao.updateState(RNum, RState);
	}
	
}
