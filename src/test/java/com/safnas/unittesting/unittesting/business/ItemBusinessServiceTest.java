package com.safnas.unittesting.unittesting.business;

import com.safnas.unittesting.unittesting.data.ItemRepository;
import com.safnas.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService business;

    @Mock
    ItemRepository repository;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(repository
                .findAll())
                .thenReturn(
                        Arrays.asList(
                                new Item(2, "Item2", 10, 100),
                                new Item(3, "Item3", 20, 40)
                        )
                );
        List<Item> items = business.retrieveAllItems();
        assertEquals(1000, items.get(0).getValue());
        assertEquals(800, items.get(1).getValue());
    }

}