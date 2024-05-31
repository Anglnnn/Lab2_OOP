package com.example.testest.controller;


import com.example.testest.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
import com.example.testest.service.UserControllerService;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private final UserControllerService userControllerService;

    public UserController (UserControllerService userControllerService){
        this.userControllerService = userControllerService;
    }

    @GetMapping(value = "/users")
    public List<UserDTO> findUser(){
        return userControllerService.findAll();
    }

    @PostMapping(value = "/blacklist/{login}")
    public UserDTO inBlacklist(@PathVariable("login") String login){
        return userControllerService.inBlacklistUser(login);
    }

    @DeleteMapping(value = "/blacklist/{login}")
    public UserDTO unBlacklist(@PathVariable("login") String login){
        return userControllerService.unBlacklistUser(login);
    }
}
