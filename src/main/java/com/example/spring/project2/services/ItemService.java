package com.example.spring.project2.services;

import com.example.spring.project2.entities.Item;

import java.util.List;

public interface ItemService {

    Item saveItem(Item item);
    List<Item> getAllItems();
    Item getItem(Long id);
    void deleteItem(Long id);
    Item updateItem(Item item);
}
