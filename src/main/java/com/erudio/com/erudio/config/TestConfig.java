package com.erudio.com.erudio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.erudio.com.erudio.entities.Person;
import com.erudio.com.erudio.repositories.PersonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Person person1= new Person(null,"John","Constantine","Londres","male");
		Person person2= new Person(null,"John","Stewart","Los Angeles","male");
		Person person3= new Person(null,"Natasha","Romanoff","Budapeste-Rússia","female");
		
		personRepository.saveAll(Arrays.asList(person1,person2,person3));
		
	}

}
