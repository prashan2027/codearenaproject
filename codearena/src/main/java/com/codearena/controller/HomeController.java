package com.codearena.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api")
public class HomeController {

    @GetMapping("/check")
    public String check(){
        return "it working ";
    }

}
