package com.curso.erudio.rest_spring_aws.controllers;

import com.curso.erudio.rest_spring_aws.controllers.annotations.*;
import com.curso.erudio.rest_spring_aws.data.vo.v1.PersonVO;
import com.curso.erudio.rest_spring_aws.services.PersonService;
import com.curso.erudio.rest_spring_aws.util.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person/v1")
@Tag(name = "Pessoas", description = "Endpoints for managing people")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    @OpFindAllPersonDoc
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    @OpFindByIdDoc
    public PersonVO findById(@PathVariable(value = "id") String id) {
        return service.findById(Long.valueOf(id));
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    @OpCreateDoc
    public PersonVO create(@RequestBody PersonVO person) {
        return service.create(person);
    }

    @PutMapping(produces = {
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    @OpUpdateDoc
    public PersonVO update(@RequestBody PersonVO person) {
        return service.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @OpDeleteDoc
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(Long.valueOf(id));
    }

}
