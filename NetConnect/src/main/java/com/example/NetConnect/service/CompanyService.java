package com.example.NetConnect.service;

import com.example.NetConnect.Nodes.Company;
import com.example.NetConnect.constants.MessageConstants;
import com.example.NetConnect.repository.CompanyRepo;
import com.example.NetConnect.repository.JobRepo;
import com.example.NetConnect.repository.PersonRepo;
import com.example.NetConnect.utils.CommonResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CompanyService {
    private static final Logger log = LoggerFactory.getLogger(CompanyService.class);
    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private JobRepo jobRepo;


    public ResponseEntity<?> addCompany(Company company) {
        CommonResponseObject commonResponseObject = new CommonResponseObject();
        CommonResponseObject.buildFailureResponse(commonResponseObject, MessageConstants.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        try{
            Company savedCompany = companyRepo.save(company);
            CommonResponseObject.buildSuccessResponse(commonResponseObject,MessageConstants.DATA_SAVED_SUCCESSFULLY, Collections.singletonList(savedCompany),HttpStatus.CREATED);
            return new ResponseEntity<>(commonResponseObject,HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Error in addCompany() : {}",e.getMessage());
            commonResponseObject.setMessage(e.getMessage());
        }
        return new ResponseEntity<>(commonResponseObject,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
