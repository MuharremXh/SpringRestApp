package com.rremi.rest_app.controllers;

import com.rremi.rest_app.errorHandling.Error;
import com.rremi.rest_app.errorHandling.UserNotFoundException;
import com.rremi.rest_app.entities.Item;
import com.rremi.rest_app.entities.User;
import com.rremi.rest_app.errorHandling.itemNotFoundExcwption;
import com.rremi.rest_app.repositories.itemRepository;
import com.rremi.rest_app.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class itemController {

    private com.rremi.rest_app.repositories.userRepository userRepository;
    private com.rremi.rest_app.repositories.itemRepository itemRepository;

    @Autowired
    public itemController(userRepository userRepository,itemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    //show all items
    @GetMapping("/items")
    public List<Item> items(){
        return itemRepository.findAll();
    }

    //show the specified item given the id
    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable(name = "itemId")Long id){
        return itemRepository.findById(id).orElseThrow(() -> new itemNotFoundExcwption(id));
    }

    //show the user's items given his id
    @GetMapping("/userItems/{userId}")
    public List<Item> getItemsByUserId(@PathVariable(name = "userId") Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return itemRepository.findAllByItemOwner(user);
    }

    @PostMapping("/items/addItem")
    public Item addItem(@RequestBody Item item){
        itemRepository.save(item);
        return itemRepository.findById(item.getId()).orElseThrow(() -> new itemNotFoundExcwption(item.getId()));
    }

    //handle itemNotFoundExceptions
    @ExceptionHandler(itemNotFoundExcwption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error itemNotfound(itemNotFoundExcwption intf){
        return  new Error(404,"Item with id "+intf.getId()+" not found");
    }
}
