package com.grayMatter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grayMatter.entity.Book;
import com.grayMatter.services.BookServices;

@Controller
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	BookServices service;
	
	@GetMapping("/book")
	public ResponseEntity<?> getAllBook(){
		return service.getAllBook();
	}
	@PostMapping("/book")
	public ResponseEntity<?> addBook(@RequestBody Book b){
		return service.addBook(b);
	}
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") int id){
		return service.deleteBook(id);
	}
	@PutMapping("/book")
	public ResponseEntity<?> updateBook(@RequestBody Book b){
		return service.updateBook(b);
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getByID(@PathVariable("id") int id){
		return service.getByID(id);
	}
}
