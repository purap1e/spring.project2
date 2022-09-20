package com.example.spring.project2.services.impl;

import com.example.spring.project2.entities.ApplicationRequest;
import com.example.spring.project2.entities.Categories;
import com.example.spring.project2.entities.Courses;
import com.example.spring.project2.repositories.CategoriesRepository;
import com.example.spring.project2.repositories.CourseRepository;
import com.example.spring.project2.repositories.RequestRepository;
import com.example.spring.project2.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public ApplicationRequest saveRequest(ApplicationRequest request) {
        return requestRepository.save(request);
    }

    @Override
    public List<ApplicationRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public ApplicationRequest getRequest(Long id) {
        var request = requestRepository.findById(id);

        if(request.isPresent()){
            return request.get();
        }else {
            throw new RuntimeException("entity not found with id = " + id);
        }
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.delete(getRequest(id));
    }

    @Override
    public ApplicationRequest updateRequest(ApplicationRequest request) {
        return requestRepository.save(request);
    }

    @Override
    public List<ApplicationRequest> getAllRequestsByHandled(Boolean handled) {
        return requestRepository.findAllByHandledIs(handled);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses getCourse(Long id) {
        var course =  courseRepository.findById(id);

        if(course.isPresent()) {
            return course.get();
        }else {
            throw new RuntimeException("entity not found with id = " + id);
        }
    }

    @Override
    public Courses addCourse(Courses course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories getCategory(Long id) {
        var category = categoriesRepository.findById(id);

        if(category.isPresent()){
            return category.get();
        }else {
            throw new RuntimeException("entity not found with id = " + id);
        }
    }
}
