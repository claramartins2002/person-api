package com.clara.personApi.controller;


import com.clara.personApi.dto.MessageResponse;
import com.clara.personApi.entity.Person;
import com.clara.personApi.exceptions.PersonNotFoundException;
import com.clara.personApi.repository.PersonRepository;
import com.clara.personApi.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    private PersonServices personServices;
    @Autowired
    public PersonController(PersonServices personService){
        this.personServices= personService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createPerson(@RequestBody @Valid Person person) {
      return personServices.createPerson(person);
    }

    @GetMapping
    public List<Person> listAll() {
     return  personServices.listAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) throws PersonNotFoundException {
        return personServices.findByid(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable  Long id) throws PersonNotFoundException {
        personServices.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateById(@PathVariable  Long id, @RequestBody Person person) throws PersonNotFoundException {
        return personServices.updatePerson(id, person);
    }
}
