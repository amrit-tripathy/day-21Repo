package com.grayMatter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.grayMatter.entity.Person;
import com.grayMatter.repository.PersonRepository;

@Repository
public class PersonDao {
	@Autowired
	PersonRepository repository;
	
	public ResponseEntity<?> getAllPersons(){
		List<Person> plist = repository.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(!plist.isEmpty()) {
			map.put("status", 10);
			map.put("data", plist);
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("status", 20);
			map.put("data", "list is empty");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
	}

	public ResponseEntity<?> addPerson(Person np) {
		Person p = repository.save(np);
		Map<String, Object> map = new HashMap<String, Object>();
		if(p!=null) {
			map.put("status",11);
			map.put("data", p);
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		}
		else {
			map.put("status", 21);
			map.put("data", "record not set");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		} 
	}
	public ResponseEntity<?> deletePerson(long aid) {
		List<Person>plist = repository.findAll();
		Map<String, Object>map = new HashMap<String, Object>();
		
		for(Person p:plist) {
			if(p.getAadharnum()==aid) {
				map.put("status",15);
				map.put("data", "record deleted succesfully");
				repository.delete(p);
				return new ResponseEntity<>(map,HttpStatus.ACCEPTED);
			}
		}
		map.put("status",21);
		map.put("data", "record is not deleted");
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<?> updatePerson(Person np) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Person>plist = repository.findAll();
		for(Person p:plist) {
			if(p.getAadharnum()==np.getAadharnum()) {
				repository.delete(p);
				map.put("status",15);
				map.put("data", "record updated succesfully");
				repository.save(np);
				return new ResponseEntity<>(map,HttpStatus.ACCEPTED);
			}
		}
		 
			map.put("status",21);
			map.put("data", "record is not UPDATED");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
		
	}
	public ResponseEntity<?> getPersonByid(int id) {
		Map<String,Object> map = new HashMap<String, Object>();
		Person p = repository.findById((long) id).get();
		if(p!=null) {
			map.put("status", 10);
			map.put("data", p);
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			map.put("status", 20);
			map.put("data", "list is empty");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
