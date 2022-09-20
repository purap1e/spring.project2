package com.example.spring.project2.controllers;

import com.example.spring.project2.entities.Courses;
import com.example.spring.project2.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private RequestService requestService;

    @GetMapping(value = "/addCourse")
    public String getCourse(){
        return "/addCourse";
    }

    @PostMapping(value = "/addCourse")
    public String addCourse(@ModelAttribute(name = "newCourse") Courses course) {
        requestService.addCourse(course);
        return "redirect:/allRequests";
    }
}
