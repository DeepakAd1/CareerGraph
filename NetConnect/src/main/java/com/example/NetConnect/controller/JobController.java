package com.example.NetConnect.controller;

import com.example.NetConnect.Nodes.Job;
import com.example.NetConnect.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/addJob")
    public ResponseEntity<?> addJob(@RequestBody Job job){
        return jobService.addJob(job);
    }
}
