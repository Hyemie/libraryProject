package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.RegBookMapper;

import vo.RegBookVO;

@Component
public class RegBookDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int Reginsert(RegBookVO regbook) {
		RegBookMapper mapper = session.getMapper(RegBookMapper.class);
		return mapper.Reginsert(regbook);
	}
	
	public List<RegBookVO> selectBookList(){
		RegBookMapper mapper = session.getMapper(RegBookMapper.class);
		return mapper.selectAll();
	}
	
	public RegBookVO selectBook(int RNum, int RState) {
		RegBookMapper mapper = session.getMapper(RegBookMapper.class);
		return mapper.select(RNum, RState);
	}
	
	public int updateState(int RNum, int RState) {
		RegBookMapper mapper = session.getMapper(RegBookMapper.class);
		return mapper.updateState(RNum, RState);
	}

}
