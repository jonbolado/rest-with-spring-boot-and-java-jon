package com.curso.erudio.rest_spring_aws.unittests.mappers.mocks;

import com.curso.erudio.rest_spring_aws.data.vo.v1.PersonVO;
import com.curso.erudio.rest_spring_aws.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity(Integer id) {
        Person person = new Person();
        person.setId(id.longValue());
        person.setFirstName("First name test " + id);
        person.setLastName("Last name test " + id);
        person.setAddress("Address test " + id);
        person.setGender("Gender test " + id);
        return person;
    }

    public PersonVO mockVO(Integer id) {
        PersonVO person = new PersonVO();
        person.setId(id.longValue());
        person.setFirstName("First name test " + id);
        person.setLastName("Last name test " + id);
        person.setAddress("Address test " + id);
        person.setGender("Gender test " + id);
        return person;
    }

    public List<Person> mockEntityList(Integer size) {
        List<Person> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(mockEntity(i));
        }
        return list;
    }

    public List<PersonVO> mockVOList(Integer size) {
        List<PersonVO> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(mockVO(i));
        }
        return list;
    }

}
