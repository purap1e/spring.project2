package com.example.spring.project2.controllers;

import com.example.spring.project2.entities.Item;
import com.example.spring.project2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class HomeController {

    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/")
    public String getMainPage(Model model){

        List<Item> items = itemService.getAllItems();
        model.addAttribute("items",items);

        return "/index";
    }

    @PostMapping(value = "/addItem")
    public String addItem(@ModelAttribute(name = "newItem") Item item) {
        itemService.saveItem(item);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id) {
        Item item = itemService.getItem(id);
        model.addAttribute("it", item);
        return "/details";
    }

    @PostMapping(value = "/saveItem")
    public String saveItem(@ModelAttribute(name = "newItem") Item item){
        itemService.updateItem(item);
        return "redirect:/";
    }

    @GetMapping(value = "/deleteItem/{id}")
    public String deleteItem(@PathVariable(name = "id") Long id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }

}
