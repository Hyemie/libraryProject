package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.BrAdminMapper;

import vo.BrAdminVO;

@Component
public class BrAdminDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int insert(BrAdminVO adminlist) {
		BrAdminMapper mapper = session.getMapper(BrAdminMapper.class);
		return mapper.insert(adminlist);
	}
	
	public List<BrAdminVO> selectAdminList(){
		BrAdminMapper mapper = session.getMapper(BrAdminMapper.class);
		return mapper.selectAll();
	}
	
	public BrAdminVO select(int BrNum) {
		BrAdminMapper mapper = session.getMapper(BrAdminMapper.class);
		return mapper.select(BrNum);
	}
	
	public int AddDate(BrAdminVO adminlist) {
		BrAdminMapper mapper = session.getMapper(BrAdminMapper.class);
		return mapper.AddDate(adminlist);
	}
	
	public int changeStatus(int BrNum) {
		BrAdminMapper mapper = session.getMapper(BrAdminMapper.class);
		return mapper.changeStatus(BrNum);
	}
	
	public int borrowBook(int BrNum) {
		BrAdminMapper mapper = session.getMapper(BrAdminMapper.class);
		return mapper.changeStatus(BrNum);
	}
	
	public int returnBook(int BrNum) {
		BrAdminMapper mapper = session.getMapper(BrAdminMapper.class);
		return mapper.returnBook(BrNum);
	}

}
