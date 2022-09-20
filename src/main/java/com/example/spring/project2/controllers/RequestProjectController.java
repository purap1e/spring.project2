package com.example.spring.project2.controllers;


import com.example.spring.project2.entities.ApplicationRequest;
import com.example.spring.project2.entities.Categories;
import com.example.spring.project2.entities.Courses;
import com.example.spring.project2.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RequestProjectController {

    private RequestService requestService;

    @Autowired
    public RequestProjectController(RequestService requestService) {
        this.requestService = requestService;
    }


    @GetMapping(value = "/allRequests")
    public String getAllRequestPage(Model model){
        List<ApplicationRequest> requestList = requestService.getAllRequests();
        model.addAttribute("requests", requestList);

        List<Courses> courses = requestService.getAllCourses();
        model.addAttribute("courses", courses);
        return "/allRequests";
    }

    @GetMapping(value = "/addRequest")
    public String getAddRequest(Model model){
        List<Courses> courses = requestService.getAllCourses();
        model.addAttribute("courses", courses);
        return "/addRequest";
    }

    @PostMapping(value = "/addRequest")
    public String addRequest(@RequestParam(name = "user_name") String name,
                             @RequestParam(name = "course_id") Long idCourse,
                             @RequestParam(name = "phone") String phone,
                             @RequestParam(name = "comment") String comment){

        ApplicationRequest request = new ApplicationRequest(null,name,requestService.getCourse(idCourse),phone,comment,false,null);
        requestService.saveRequest(request);
        return "redirect:/allRequests";
    }

    @GetMapping(value = "/detailsRequest/{id}")
    public String getDetailsRequest(Model model, @PathVariable(name = "id") Long id) {
        ApplicationRequest request = requestService.getRequest(id);
        model.addAttribute("rq",request);

        List<Courses> courses = requestService.getAllCourses();
        model.addAttribute("courses", courses);

        List<Categories> categories = requestService.getAllCategories();
        model.addAttribute("categories", categories);

        if(request.isHandled()){
            return "/detailsTRUERequest";
        }else {
            return "/detailsRequest";
        }
    }

    @GetMapping(value = "/deleteRequest/{id}")
    public String deleteRequest(@PathVariable(name = "id") Long id) {
        requestService.deleteRequest(id);
        return "redirect:/allRequests";
    }

    @PostMapping(value = "/updateRequest")
    public String updateRequest(@RequestParam(name = "id") Long id,
                                @RequestParam(name = "userName") String name,
                                @RequestParam(name = "course_id") Long idCourse,
                                @RequestParam(name = "phone") String phone,
                                @RequestParam(name = "comment") String comment) {
        ApplicationRequest request = requestService.getRequest(id);
        if(request!=null){
            request.setUserName(name);
            request.setCourseName(requestService.getCourse(idCourse));
            request.setPhone(phone);
            request.setComment(comment);
            request.setHandled(true);
            requestService.updateRequest(request);
        }


        return "redirect:/allRequests";
    }

    @GetMapping(value = "/newRequests")
    private String getNewRequests(Model model){
        List<ApplicationRequest> requestList = requestService.getAllRequestsByHandled(false);
        model.addAttribute("requests", requestList);

        return "/newRequests";
    }

    @GetMapping(value = "/oldRequests")
    private String getOldRequests(Model model){
        List<ApplicationRequest> requestList = requestService.getAllRequestsByHandled(true);
        model.addAttribute("requests", requestList);

        return "/oldRequests";
    }

    @PostMapping(value = "/addCategory")
    public String addCategory(@RequestParam(name = "request_id") Long requestId,
                              @RequestParam(name = "category_id") Long categoryId) {

        ApplicationRequest request = requestService.getRequest(requestId);

        if(request!=null) {
            Categories category = requestService.getCategory(categoryId);
            if(category!=null) {
                List<Categories> categories = request.getCategory();
                if(categories==null) {
                    categories = new ArrayList<>();
                }
                categories.add(category);
                requestService.updateRequest(request);
                return "redirect:/detailsRequest/"+request.getId();
            }
        }
        return "redirect:/allRequests";
    }
}
