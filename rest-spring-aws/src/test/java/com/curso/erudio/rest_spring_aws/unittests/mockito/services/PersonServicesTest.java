package com.curso.erudio.rest_spring_aws.unittests.mockito.services;

import com.curso.erudio.rest_spring_aws.data.vo.v1.PersonVO;
import com.curso.erudio.rest_spring_aws.exceptions.RequiredObjectIsNullException;
import com.curso.erudio.rest_spring_aws.mapper.Mapper;
import com.curso.erudio.rest_spring_aws.model.Person;
import com.curso.erudio.rest_spring_aws.repositories.PersonRepository;
import com.curso.erudio.rest_spring_aws.services.PersonService;
import com.curso.erudio.rest_spring_aws.unittests.mappers.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;

public class PersonServicesTest {

    MockPerson mockPerson;

    @InjectMocks
    private PersonService service;

    @Mock
    private PersonRepository repository;

    @BeforeEach
    void setUp() {
        mockPerson = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Person person = mockPerson.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        var resultado = service.findById(1L);

        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertNotNull(resultado.getFirstName());
        assertEquals("First name test " + person.getId(), resultado.getFirstName());
        assertEquals("Last name test " + person.getId(), resultado.getLastName());
        assertEquals("Address test " + person.getId(), resultado.getAddress());
        assertEquals("Gender test " + person.getId(), resultado.getGender());
    }

    @Test
    void testFindAll() {
        List<Person> list = mockPerson.mockEntityList(10);
        when(repository.findAll()).thenReturn(list);

        var resultado = service.findAll();

        assertNotNull(resultado);
        assertEquals(10, resultado.size());
        assertEquals("First name test " + list.get(0).getId(), list.get(0).getFirstName());
        assertEquals("Last name test " + list.get(0).getId(), list.get(0).getLastName());
        assertEquals("Address test " + list.get(0).getId(), list.get(0).getAddress());
        assertEquals("Gender test " + list.get(0).getId(), list.get(0).getGender());
    }

    @Test
    void testCreate() {

        Person novaPessoa = mockPerson.mockEntity(1);
        novaPessoa.setId(null);
        Person persistido = mockPerson.mockEntity(1);

        when(repository.save(novaPessoa)).thenReturn(persistido);

        PersonVO resultado = service.create(Mapper.parseObject(novaPessoa, PersonVO.class));

        assertNotNull(resultado);
        assertEquals(persistido.getId(), resultado.getId());
        assertEquals(persistido.getFirstName(), resultado.getFirstName());
        assertEquals(persistido.getLastName(), resultado.getLastName());
        assertEquals(persistido.getAddress(), resultado.getAddress());
        assertEquals(persistido.getGender(), resultado.getGender());
    }

    @Test
    void testUpdate() {
        Person pessoa = mockPerson.mockEntity(1);
        PersonVO vo = mockPerson.mockVO(1);
        vo.setAddress("alterado");
        vo.setGender("alterado");
        vo.setLastName("alterado");
        vo.setFirstName("alterado");

        when(repository.findById(1L)).thenReturn(Optional.of(pessoa));
        when(repository.save(pessoa)).thenReturn(Mapper.parseObject(vo, Person.class));

        var atualizado = service.update(vo);

        assertNotNull(atualizado);
        assertEquals(1L, atualizado.getId());
        assertEquals("alterado", atualizado.getFirstName());
        assertEquals("alterado", atualizado.getGender());
        assertEquals("alterado", atualizado.getLastName());
        assertEquals("alterado",  atualizado.getAddress());
    }

    @Test
    void testDelete() {
        Person person = mockPerson.mockEntity(1);
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        service.delete(1L);
    }

    @Test
    void testCreateWithNullPerson() {

        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> service.create(null));

        String expectedMessage = "Os dados da pessoa são obrigatórios.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

}
