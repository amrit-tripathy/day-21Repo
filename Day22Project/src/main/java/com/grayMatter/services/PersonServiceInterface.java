package com.grayMatter.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grayMatter.entity.Person;


public interface PersonServiceInterface  {
	
	public ResponseEntity<?> getAllPersons();

	public ResponseEntity<?> addPerson(Person p);

	public ResponseEntity<?> deletePerson(long aid);

	public ResponseEntity<?> getPersonByid(int aid);

	 public ResponseEntity<?> updatePerson(Person p);
	
	
}
