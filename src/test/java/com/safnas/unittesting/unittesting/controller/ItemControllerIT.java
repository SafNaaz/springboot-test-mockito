package com.safnas.unittesting.unittesting.controller;

import com.safnas.unittesting.unittesting.data.ItemRepository;
import com.safnas.unittesting.unittesting.model.Item;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ItemRepository repository;

    @Test
    public void contextLoads() throws JSONException {
        when(repository
                .findAll())
                .thenReturn(
                        Arrays.asList(
                                new Item(2, "Item2", 10, 100),
                                new Item(3, "Item3", 20, 40)
                        )
                );

        String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:2},{id:3}]", response, false);
    }
}
