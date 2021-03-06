package com.clara.personApi.services;


import com.clara.personApi.dto.MessageResponse;
import com.clara.personApi.dto.request.PersonDto;
import com.clara.personApi.entity.Person;
import com.clara.personApi.exceptions.PersonNotFoundException;
import com.clara.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServices {
    private PersonRepository personRepository;

    @Autowired
    public PersonServices(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponse createPerson(@RequestBody Person person) {


        Person savedPerson= personRepository.save(person);
        return MessageResponse.builder().
                message("Created person with id "+savedPerson.getId()).build();
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person findByid(Long id) throws PersonNotFoundException {
 Person optionalPerson = personRepository.findById(id)
         .orElseThrow(() -> new PersonNotFoundException(id));

    return optionalPerson;
    }

    public void delete(Long id) throws PersonNotFoundException{
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);

    }

    public MessageResponse updatePerson(Long id, Person person) throws PersonNotFoundException {
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        Person savedPerson= personRepository.save(person);
        return MessageResponse.builder().
                message("Updated person with id "+savedPerson.getId()).build();

    }
}
