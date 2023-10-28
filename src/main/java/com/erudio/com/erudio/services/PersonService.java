package com.erudio.com.erudio.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.com.erudio.data.vo.v1.PersonVO;
import com.erudio.com.erudio.data.vo.v2.PersonVOV2;
import com.erudio.com.erudio.entities.Person;
import com.erudio.com.erudio.exceptions.ResourceNotFoundException;
import com.erudio.com.erudio.repositories.PersonRepository;
import com.erudio.com.erudio.resources.PersonResource;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<PersonVO>findAll(){
		List<PersonVO>list= repository.findAll().stream().map(x-> mapper.map(x, PersonVO.class)).collect(Collectors.toList());
		list.stream().map(x->x.add(linkTo(methodOn(PersonResource.class).findById(x.getId())).withSelfRel())).collect(Collectors.toList());
		return list;
	}
	public PersonVO findById(Long id) {
		Person person= repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Objeto não encontrado"));
		
		PersonVO vo= mapper.map(person, PersonVO.class);
		vo.add(linkTo(methodOn(PersonResource.class).findById(id)).withSelfRel());
		
		return vo;
	}
	public Person insert(Person person) {
		return repository.save(person);
	}
	public Person insertV2(PersonVOV2 personv2) {
		Person person=mapper.map(personv2, Person.class);
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
