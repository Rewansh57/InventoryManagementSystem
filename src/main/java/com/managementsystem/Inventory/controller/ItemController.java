package com.managementsystem.Inventory.controller;

import com.managementsystem.Inventory.model.Item;
import com.managementsystem.Inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    //Posting an item 
    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);

    }
    //Getting all items 
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();

    }
    //Get item by id avoiding nullpointer exception
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long  id){
        Optional<Item> optionalItem=itemService.getItembyId(id);
        return optionalItem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    //updation of posted details 
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id ,@RequestBody Item item){
        return itemService.updateItem(id,item);

    }
    // deleting given details 
    @DeleteMapping("/{id}")
    public String  deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return "Item deleted successfully";

    }
    //  Fuzzy search endpoint
    @GetMapping("/search")
    public List<Item> searchItems(@RequestParam String keyword) {
        return itemService.searchItems(keyword);
    }

}
