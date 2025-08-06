package com.example.NetConnect.controller;

import com.example.NetConnect.Nodes.Person;
import com.example.NetConnect.dtos.PersonDto;
import com.example.NetConnect.service.PersonHasSkill;
import com.example.NetConnect.service.PersonService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController("/api/person")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonHasSkill personHasSkill;

    @Autowired
    private PersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
//        personHasSkill.savePersonHasSkill();
        return ResponseEntity.ok("Saved Person and skill with has_Skill relation");
    }

    @PostMapping("/addPerson")
    public ResponseEntity<?> addPerson(@RequestBody PersonDto person){
        try{
            Person addedPerson = personService.addPerson(person);

            // Create a JSON ObjectNode
            ObjectNode response = JsonNodeFactory.instance.objectNode();
            response.set("person", objectMapper.valueToTree(addedPerson));

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }catch (Exception ex){
           log.error("Error in addPerson api : {}",ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
