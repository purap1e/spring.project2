package com.example.spring.project2.services.impl;

import com.example.spring.project2.entities.Item;
import com.example.spring.project2.repositories.ItemRepository;
import com.example.spring.project2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = getItem(id);
        itemRepository.delete(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAllXXX(3);
//        return itemRepository.findAllByAmountGreaterThanAndOOrderByPriceAsc(3);
    }

    @Override
    public Item getItem(Long id) {
        var item =  itemRepository.findById(id);
        if(item.isPresent()) {
            return item.get();
        } else {
            throw new RuntimeException("entity not found with id = " + id);
        }
    }
}
