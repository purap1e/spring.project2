package com.example.spring.project2.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestProjectController {

    @GetMapping(value = "/allRequests")
    public String getAllRequestPage(){
        return "/allRequests";
    }
}
