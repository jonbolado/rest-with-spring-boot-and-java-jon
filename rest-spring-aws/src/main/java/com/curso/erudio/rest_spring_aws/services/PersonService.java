package com.curso.erudio.rest_spring_aws.services;

import com.curso.erudio.rest_spring_aws.data.vo.v1.PersonVO;
import com.curso.erudio.rest_spring_aws.exceptions.ResourceNotFoundException;
import com.curso.erudio.rest_spring_aws.mapper.Mapper;
import com.curso.erudio.rest_spring_aws.model.Person;
import com.curso.erudio.rest_spring_aws.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        return Mapper.parseList(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        return Mapper.parseObject(
                repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nenhuma pessoa encontrada para o ID = " + id + ".")), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        return Mapper.parseObject(
                repository.save(
                        Mapper.parseObject(person, Person.class)), PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        var personUpdate = repository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Nenhuma pessoa encontrada para o ID = " + person.getId() + "."));

        personUpdate.setFirstName(person.getFirstName());
        personUpdate.setLastName(person.getLastName());
        personUpdate.setAddress(person.getAddress());
        personUpdate.setGender(person.getGender());

        return Mapper.parseObject(repository.save(personUpdate), PersonVO.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
