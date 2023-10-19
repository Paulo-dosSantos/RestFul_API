package com.erudio.com.erudio.resources;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
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
import com.erudio.com.erudio.config.custom.PersonMapper;
import com.erudio.com.erudio.data.vo.v1.PersonVO;
import com.erudio.com.erudio.data.vo.v2.PersonVOV2;
import com.erudio.com.erudio.entities.Person;
import com.erudio.com.erudio.services.PersonService;

@RestController
@RequestMapping(value="/persons")
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PersonMapper personMapper;
	
	@GetMapping
	public ResponseEntity<List<PersonVO>>findAll(){
		List<PersonVO>list=service.findAll().stream().map(x->mapper.map(x, PersonVO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<PersonVO>findById(@PathVariable Long id){
		PersonVO person=mapper.map(service.findById(id), PersonVO.class);
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
	@PostMapping(value="/v2")
	public ResponseEntity<PersonVOV2>insertV2(@RequestBody PersonVOV2 person){
		Person entity= service.insertV2(person);
		return ResponseEntity.ok().body(personMapper.convertEntityToVO(entity));
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<PersonVO>update(@PathVariable Long id,@RequestBody PersonVO person){
		person.setId(id);
		PersonVO newPerson=mapper.map(service.update(id, person), PersonVO.class);
		return ResponseEntity.ok().body(newPerson);
		
	}

}
