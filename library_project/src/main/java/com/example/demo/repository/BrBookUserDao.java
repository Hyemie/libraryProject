package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.BrBookUserMapper;

import vo.BrBookUserVO;

@Component
public class BrBookUserDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	
	
	public int insert(BrBookUserVO brBookUser) {
		BrBookUserMapper mapper = session.getMapper(BrBookUserMapper.class);
		return mapper.insert(brBookUser);
	}
	
	public List<BrBookUserVO> selectMyBrBook(String id) {
		BrBookUserMapper mapper = session.getMapper(BrBookUserMapper.class);
		return mapper.selectMyBrBook(id);
	}
	
	public List<BrBookUserVO> checkDuplBook(int bookNum) {
		BrBookUserMapper mapper = session.getMapper(BrBookUserMapper.class);
		return mapper.checkDuplBook(bookNum);
	}
	
	public int existBrCheck(String id) {
		BrBookUserMapper mapper = session.getMapper(BrBookUserMapper.class);
		return mapper.existBrCheck(id);
	}
	
	
	
}
