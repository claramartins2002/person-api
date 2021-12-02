package com.clara.personApi.services;


import com.clara.personApi.dto.MessageResponse;
import com.clara.personApi.entity.Person;
import com.clara.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonServices {
    private PersonRepository personRepository;

    @Autowired
    public PersonServices(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponse createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponse.builder().
                message("Created person with id "+savedPerson.getId()).build();
    }
}
