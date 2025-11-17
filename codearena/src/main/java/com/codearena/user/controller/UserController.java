package com.codearena.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public ResponseEntity<?> getproblemslist(){
        return ResponseEntity.ok().build();
    }
}
