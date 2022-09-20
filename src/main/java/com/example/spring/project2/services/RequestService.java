package com.example.spring.project2.services;

import com.example.spring.project2.entities.ApplicationRequest;
import com.example.spring.project2.entities.Categories;
import com.example.spring.project2.entities.Courses;
import com.example.spring.project2.entities.Item;

import java.util.List;

public interface RequestService {
    ApplicationRequest saveRequest(ApplicationRequest request);
    List<ApplicationRequest> getAllRequests();
    ApplicationRequest getRequest(Long id);
    void deleteRequest(Long id);
    ApplicationRequest updateRequest(ApplicationRequest request);
    List<ApplicationRequest> getAllRequestsByHandled(Boolean handled);
    List<Courses> getAllCourses();
    Courses getCourse(Long id);
    Courses addCourse(Courses course);
    List<Categories> getAllCategories();
    Categories getCategory(Long id);

}
