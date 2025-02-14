package com.managementsystem.Inventory.controller;

import com.managementsystem.Inventory.model.User;
import com.managementsystem.Inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthContoller {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        if (userService.findByUsername(user.getUsername()).isPresent()){
return "User already exists";

        }
        userService.registerUser(user);
return "User registered";

    }
    @PostMapping ("/login")
    public String login(){
        return "login endpoint ";
    }


}
