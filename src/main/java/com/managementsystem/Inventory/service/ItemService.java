package com.managementsystem.Inventory.service;

import com.managementsystem.Inventory.Repository.ItemRepository;
import com.managementsystem.Inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
//Crud Operations with fuzzy search
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();

    }
    public Item createItem(Item item){
        return itemRepository.save(item);

    }
    public Optional<Item> getItembyId(Long id)
    {
        return itemRepository.findById(id);

    }
    public Item updateItem(Long id ,Item updatedItem){
        return itemRepository.findById(id).map(item->{
            item.setName(updatedItem.getName());
            item.setDescription(updatedItem.getDescription());
            item.setQuantity(updatedItem.getQuantity());
            return itemRepository.save(item);}).orElse(null);



        }
        public void deleteItem (Long id){
        itemRepository.deleteById(id);

    }
    public List<Item> searchItems(String keyword) {
        return itemRepository.searchItemsByKeyword(keyword);
    }

}
