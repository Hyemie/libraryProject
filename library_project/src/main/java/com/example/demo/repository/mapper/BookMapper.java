package com.example.demo.repository.mapper;

import java.util.List;

import vo.BookVO;

public interface BookMapper {
	
	public int insert(BookVO book);
	public List<BookVO> selectAll();
	public int update(BookVO book);
	public int delete(int bookNum);
	public BookVO select(int bookNum);

}
