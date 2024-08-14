package com.grayMatter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.BookDao;
import com.grayMatter.entity.Book;

@Service
public class BookServices {
	@Autowired
	private BookDao dao;
	public ResponseEntity<?> getAllBook(){
		return dao.getAllBook();
	}
	public ResponseEntity<?> addBook(Book b){
		return dao.addBook(b);
	}
	public ResponseEntity<?> deleteBook(int id){
		return dao.deleteBook(id);
	}
	public ResponseEntity<?> updateBook(Book b){
		return dao.updateBook(b);
	}
	public ResponseEntity<?> getByID(int id){
		return dao.getByID(id);
	}
	
}
