package com.curso.erudio.rest_spring_aws.unittests.mappers;

import com.curso.erudio.rest_spring_aws.data.vo.v1.PersonVO;
import com.curso.erudio.rest_spring_aws.mapper.Mapper;
import com.curso.erudio.rest_spring_aws.model.Person;
import com.curso.erudio.rest_spring_aws.unittests.mappers.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelMapperTest {

    MockPerson mockPerson;

    @BeforeEach
    public void setUp() {
        mockPerson = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO saida = Mapper.parseObject(mockPerson.mockEntity(1), PersonVO.class);
        assertEquals("First name test 1", saida.getFirstName());
        assertEquals("Last name test 1", saida.getLastName());
        assertEquals("Address test 1", saida.getAddress());
        assertEquals("Gender test 1", saida.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person saida = Mapper.parseObject(mockPerson.mockVO(1), Person.class);
        assertEquals("First name test 1", saida.getFirstName());
        assertEquals("Last name test 1", saida.getLastName());
        assertEquals("Address test 1", saida.getAddress());
        assertEquals("Gender test 1", saida.getGender());
    }

    @Test
    public void parseListEntityToVOTest() {

        List<PersonVO> saida = Mapper.parseList(mockPerson.mockEntityList(10), PersonVO.class);

        assertEquals(saida.size(), 10);
        assertEquals(saida.get(0).getFirstName(), "First name test 0");
        assertEquals(saida.get(0).getLastName(), "Last name test 0");
        assertEquals(saida.get(9).getFirstName(), "First name test 9");
        assertEquals(saida.get(9).getLastName(), "Last name test 9");
    }

    @Test
    public void parseListVOToEntityTest() {

        List<Person> saida = Mapper.parseList(mockPerson.mockVOList(10), Person.class);

        assertEquals(saida.size(), 10);
        assertEquals(saida.get(0).getFirstName(), "First name test 0");
        assertEquals(saida.get(0).getLastName(), "Last name test 0");
        assertEquals(saida.get(9).getFirstName(), "First name test 9");
        assertEquals(saida.get(9).getLastName(), "Last name test 9");
    }

}
