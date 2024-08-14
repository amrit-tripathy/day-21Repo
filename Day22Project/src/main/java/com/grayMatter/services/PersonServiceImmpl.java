package com.grayMatter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.PersonDao;
import com.grayMatter.entity.Person;

@Service
public class PersonServiceImmpl implements PersonServiceInterface {
	@Autowired
	PersonDao dao;
	
	@Override
	public ResponseEntity<?> getAllPersons() {
		return dao.getAllPersons();
	}
	@Override
	public ResponseEntity<?> addPerson(Person p) {
		return dao.addPerson(p);
	}
	@Override
	public ResponseEntity<?> deletePerson(long aid) {
		return dao.deletePerson(aid);
	}
	@Override
	public ResponseEntity<?> updatePerson(Person p) {
		return dao.updatePerson(p);
	}
	@Override
	public  ResponseEntity<?>getPersonByid(int id) {
		return dao.getPersonByid(id);
	}
	

}




