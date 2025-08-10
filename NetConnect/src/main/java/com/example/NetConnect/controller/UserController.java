package com.example.NetConnect.controller;

import com.example.NetConnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/checkOrGenerateUsername")
    public ResponseEntity<?> checkOrGenerateUsername(@RequestParam String desiredUsername) {
        return userService.checkOrGenerateUserName(desiredUsername);
    }



}
