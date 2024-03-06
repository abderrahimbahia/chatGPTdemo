package com.infosys.chatGPTdemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "Hello from spring boot gpt demo!";
    }
}
