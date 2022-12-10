package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.BrBookUserVO;

public interface BrBookUserMapper {

	public int insert(BrBookUserVO brBookUser);
	public List<BrBookUserVO> selectMyBrBook(@Param("userId") String id);
	public List<BrBookUserVO> checkDuplBook(int bookNum);
	public int existBrCheck(String id);
	
}
