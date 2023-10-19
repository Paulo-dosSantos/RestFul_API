package com.erudio.com.erudio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.com.erudio.data.vo.v1.PersonVO;
import com.erudio.com.erudio.entities.Person;
import com.erudio.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Person>findAll(){
		List<Person>list= repository.findAll();
		return list;
	}
	public Person findById(Long id) {
		Person person= repository.findById(id).get();
		return person;
	}
	public Person insert(Person person) {
		return repository.save(person);
	}
	public void delete(Long id) {
		findById(id);
		 repository.deleteById(id);
	}
	public Person update(Long id,PersonVO person) {
		findById(id);
			
		return repository.save(mapper.map(person, Person.class));
	}

}
