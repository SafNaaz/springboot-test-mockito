package com.safnas.unittesting.unittesting.business;

import com.safnas.unittesting.unittesting.data.ItemRepository;
import com.safnas.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItems() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = repository.findAll();
        items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
        return items;
    }
}
