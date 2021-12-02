package com.clara.personApi.controller;


import com.clara.personApi.dto.MessageResponse;
import com.clara.personApi.entity.Person;
import com.clara.personApi.repository.PersonRepository;
import com.clara.personApi.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public MessageResponse createPerson(@RequestBody Person person) {
      return personServices.createPerson(person);
    }
}
