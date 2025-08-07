package com.example.NetConnect.controller;

import com.example.NetConnect.Nodes.Company;
import com.example.NetConnect.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    public ResponseEntity<?> addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }
}
