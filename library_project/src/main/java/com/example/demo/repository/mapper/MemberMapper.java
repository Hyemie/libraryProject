package com.example.demo.repository.mapper;

import org.apache.ibatis.annotations.Param;

import vo.MemberVo;

public interface MemberMapper {

	public int insert(MemberVo member);
	public MemberVo selectMember(String id);
	public int selectMemberNum(@Param("id")String id, @Param("password")String password);
	public int update(MemberVo member);
	public int delete(String id);
	
}
