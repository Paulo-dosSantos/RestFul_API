package com.erudio.com.erudio.resources;

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

import com.erudio.com.erudio.entities.Person;
import com.erudio.com.erudio.services.PersonService;

@RestController
@RequestMapping(value="/persons")
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>>findAll(){
		return ResponseEntity.ok().body(service.findAll());
		
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Person>findById(@PathVariable Long id){
		Person person=service.findById(id);
		
		return ResponseEntity.ok().body(person);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	@PostMapping
	public ResponseEntity<Person>insert(@RequestBody Person person){
		person=service.insert(person);
		
		return ResponseEntity.ok().body(person);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Person>update(@PathVariable Long id,@RequestBody Person person){
		Person newPerson=service.update(id, person);
		
		return ResponseEntity.ok().body(newPerson);
		
	}

}
