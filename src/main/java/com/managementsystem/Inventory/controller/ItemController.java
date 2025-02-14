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
    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);

    }
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long  id){
        Optional<Item> optionalItem=itemService.getItembyId(id);
        return optionalItem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id ,@RequestBody Item item){
        return itemService.updateItem(id,item);

    }
    @DeleteMapping("/{id}")
    public String  deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return "Item deleted successfully";

    }
    // ✅ Fuzzy search endpoint
    @GetMapping("/search")
    public List<Item> searchItems(@RequestParam String keyword) {
        return itemService.searchItems(keyword);
    }

}
