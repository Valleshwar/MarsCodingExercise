package com.mars.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mars.person.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
