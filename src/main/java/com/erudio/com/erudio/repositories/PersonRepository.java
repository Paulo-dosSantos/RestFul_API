package com.erudio.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erudio.com.erudio.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
