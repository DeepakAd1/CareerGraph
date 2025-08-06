package com.example.NetConnect.service;

import com.example.NetConnect.Nodes.Person;
import com.example.NetConnect.dtos.PersonDto;
import com.example.NetConnect.repository.PersonRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Person addPerson(PersonDto personDto){
        Long Dob = null ;
        if(personDto.getDateOfBirth() != null ){
            Dob = personDto.getDateOfBirth().getTime();
        }
        Person person = modelMapper.map(personDto,Person.class);
        person.setDob(Dob);
        return personRepo.save(person);
    }
}
