package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.BookMapper;

import vo.BookVO;

@Component
public class BookDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int insert(BookVO book) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.insert(book);
	}
	
	public List<BookVO> selectBookList(){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectAll();
	}
	
	public int updateBook(BookVO book) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.update(book);
	}
	
	public int deleteBook(int bookNum) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.delete(bookNum);
	}
	
	public BookVO selectBook(int bookNum) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.select(bookNum);
	}

}
