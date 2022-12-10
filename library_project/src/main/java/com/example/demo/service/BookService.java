package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.BookDao;

import vo.BookVO;

@Component
public class BookService {
	
	@Autowired
	private BookDao dao;
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	
	public int addBook(BookVO book) {
		dao.insert(book);
		return book.getBookNum();
	}
	
	public List<BookVO> getTotalBook(){
		return dao.selectBookList();
	}
	
	public int deleteBook(int bookNum) {
		return dao.deleteBook(bookNum);
	}
	
	public int modifyBook(BookVO book) {
		return dao.updateBook(book);
	}
	
	public BookVO readBook(int bookNum) {
		return dao.selectBook(bookNum);
	}
	
}
