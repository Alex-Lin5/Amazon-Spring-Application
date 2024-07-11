package com.revature.AmazonSpringApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="")
public class Controller {
    @GetMapping(value = "/")
    public ResponseEntity<String> Home(){
        return ResponseEntity.status(HttpStatus.OK).body("Home\n");
    }
}
