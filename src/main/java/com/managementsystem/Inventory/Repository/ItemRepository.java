package com.managementsystem.Inventory.Repository;

import com.managementsystem.Inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//Defining repository for items in inventory and jpa support for database
public interface ItemRepository  extends JpaRepository<Item, Long> {
    //For fuzzy seaching even with a minor spelling mistakes and case senstivity basically a sql query
    @Query("SELECT i FROM Item i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Item> searchItemsByKeyword(@Param("keyword") String keyword);
}
