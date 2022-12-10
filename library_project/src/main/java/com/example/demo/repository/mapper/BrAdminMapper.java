package com.example.demo.repository.mapper;

import java.util.List;

import vo.BrAdminVO;

public interface BrAdminMapper {
	
	public int insert(BrAdminVO adminlist);
	public List<BrAdminVO> selectAll();
	public BrAdminVO select(int BrNum);
	public int AddDate(BrAdminVO adminlist);
	public int changeStatus(int BrNum);
	public int borrowBook(int BrNum);
	public int returnBook(int BrNum);

}
