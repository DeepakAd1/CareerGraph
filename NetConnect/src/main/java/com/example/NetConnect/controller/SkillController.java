package com.example.NetConnect.controller;

import com.example.NetConnect.Nodes.Skill;
import com.example.NetConnect.service.SkillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SkillService skillService;

    @PostMapping("/addSkill")
    public ResponseEntity<?> addSkill(@RequestBody Skill skill){
        return skillService.addSkill(skill);
    }
}
