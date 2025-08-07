package com.example.NetConnect.service;

import com.example.NetConnect.Nodes.Person;
import com.example.NetConnect.Nodes.Skill;
import com.example.NetConnect.Nodes.SkillRelation;
import com.example.NetConnect.constants.MessageConstants;
import com.example.NetConnect.dtos.PersonDto;
import com.example.NetConnect.repository.PersonRepo;
import com.example.NetConnect.repository.SkillRepo;
import com.example.NetConnect.utils.CommonResponseObject;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private SkillRepo skillRepo;

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

    public ResponseEntity<?> personToSkill(long personId, long skillId, SkillRelation skillRelation){
        CommonResponseObject commonResponseObject = new CommonResponseObject();
        CommonResponseObject.buildFailureResponse(commonResponseObject, MessageConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        try{
            Person person = personRepo.findById(personId).orElseThrow(() -> new RuntimeException("Person Not Found"));
            Skill skill = skillRepo.findById(skillId).orElseThrow(() -> new RuntimeException("Skill Not Found"));
            SkillRelation skillRt = new SkillRelation(skillRelation.getProficiency(),skill);
            person.getSkills().add(skillRt);
            Person updatedPerson = personRepo.save(person);
            CommonResponseObject.buildSuccessResponse(commonResponseObject,MessageConstants.DATA_SAVED_SUCCESSFULLY, Collections.singletonList(updatedPerson),HttpStatus.CREATED);
            return new ResponseEntity<>(commonResponseObject,HttpStatus.CREATED);
        }catch(Exception ex){
            log.error("Error in personToSkill() {}",ex.getMessage());
            commonResponseObject.setMessage(ex.getMessage());
        }
        return new ResponseEntity<>(commonResponseObject,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
