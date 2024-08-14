package com.grayMatter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.grayMatter.entity.Book;
import com.grayMatter.repository.BookRepository;

@Repository
public class BookDao {
	@Autowired
	private BookRepository repository;
	
	public ResponseEntity<?> getAllBook(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Book> blist = repository.findAll();
		if(!blist.isEmpty()) {
			map.put("status", 20);
			map.put("data", blist);
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("status", 10);
			map.put("data", "list is empty");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<?> addBook(Book b){
		Map<String, Object> map = new HashMap<String, Object>();
		Optional<Book> alreadyExistid = repository.findById(b.getId());
		if(alreadyExistid.isPresent()) {
			map.put("status", 10);
			map.put("data", "duplicate id is found ,enter a new id");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		else {
			repository.save(b);
			map.put("status", 20);
			map.put("data",b);
			map.put("message", "sucessfully added");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<?>deleteBook(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		Optional<Book> existingBook = repository.findById(id);
		if(existingBook.isPresent()) {
			repository.delete(existingBook.get());
			map.put("status", 20);
			map.put("data", "row deleted successfully");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("status", 10);
			map.put("data","requested id not found");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<?>updateBook(Book nb) {
		Map<String, Object> map = new HashMap<String, Object>();
		Optional<Book> existingBook = repository.findById(nb.getId());
		if(existingBook.isPresent()) {
			repository.delete(existingBook.get());
			repository.save(nb);
			map.put("status", 20);
			map.put("data", nb);
			map.put("message", "sucessfully updated");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("status", 10);
			map.put("data","requested id not found");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<?>getByID(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		Optional<Book> existingBook = repository.findById(id);
		if(existingBook.isPresent()) {
			map.put("status", 20);
			map.put("data", existingBook);
			map.put("message", "sucessfully fetched");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("status", 10);
			map.put("data","requested id not found");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	

}
