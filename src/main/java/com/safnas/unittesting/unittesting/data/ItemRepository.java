package com.safnas.unittesting.unittesting.data;

import com.safnas.unittesting.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
