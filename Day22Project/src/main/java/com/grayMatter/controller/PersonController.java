package com.grayMatter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.entity.Person;
import com.grayMatter.services.PersonServiceImmpl;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	@Autowired
	PersonServiceImmpl service;
		
		@GetMapping("/getallpersons")
		public ResponseEntity<?> getAllPersons(){
			return service.getAllPersons();
		}
		@PostMapping("/addperson")
		public ResponseEntity<?> addPerson(@RequestBody Person p) {
			return service.addPerson(p);
		}
		@DeleteMapping("/deletePerson/{aid}")
		public ResponseEntity<?> deletePerson(@PathVariable("aid") long aid) {
			
			return service.deletePerson(aid);
		}
		@PutMapping("/updatePerson")
		public ResponseEntity<?> updatePerson(@RequestBody Person np) {
			return service.updatePerson(np);
		}
		@GetMapping("/getperson/{aid}")
		public ResponseEntity<?> getPerson(@PathVariable("aid") int aid) {
			return service.getPersonByid(aid);
		}
		
}
