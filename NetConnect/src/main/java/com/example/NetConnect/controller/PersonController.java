package com.example.NetConnect.controller;

import com.example.NetConnect.service.PersonHasSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/person")
public class PersonController {

    @Autowired
    private PersonHasSkill personHasSkill;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        personHasSkill.savePersonHasSkill();
        return ResponseEntity.ok("Saved Person and skill with has_Skill relation");
    }
}
