package com.erudio.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.com.erudio.entities.Person;
import com.erudio.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public List<Person>findAll(){
		return repository.findAll();
	}
	public Person findById(Long id) {
		return repository.findById(id).get();
	}
	public Person insert(Person person) {
		return repository.save(person);
	}
	public void delete(Long id) {
		findById(id);
		 repository.deleteById(id);
	}
	public Person update(Long id,Person newPerson) {
		findById(id);
		return repository.save(newPerson);
	}

}
