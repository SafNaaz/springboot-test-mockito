package com.safnas.unittesting.unittesting.business;

import com.safnas.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {
    public Item retrieveHardcodedItems() {
        return new Item(1, "Ball", 10, 100);
    }
}
