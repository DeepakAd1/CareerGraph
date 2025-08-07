package com.example.NetConnect.service;

import com.example.NetConnect.Nodes.Skill;
import com.example.NetConnect.constants.MessageConstants;
import com.example.NetConnect.repository.SkillRepo;
import com.example.NetConnect.utils.CommonResponseObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Slf4j
@Service
public class SkillService {

    private static final Logger log = LoggerFactory.getLogger(SkillService.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SkillRepo skillRepo;

    public ResponseEntity<?> addSkill(Skill skill) {
        CommonResponseObject commonResponseObject = new CommonResponseObject();
        CommonResponseObject.buildFailureResponse(commonResponseObject, MessageConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        try {
            Skill savedSkill = skillRepo.save(skill);
            CommonResponseObject.buildSuccessResponse(commonResponseObject, MessageConstants.DATA_SAVED_SUCCESSFULLY, Collections.singletonList(savedSkill), HttpStatus.CREATED);
            return new ResponseEntity<>(commonResponseObject, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error in addSkill() : {}", ex.getMessage());
        }
        return new ResponseEntity<>(commonResponseObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
