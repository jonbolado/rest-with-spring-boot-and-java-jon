package com.curso.erudio.rest_spring_aws.repositories;

import com.curso.erudio.rest_spring_aws.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
