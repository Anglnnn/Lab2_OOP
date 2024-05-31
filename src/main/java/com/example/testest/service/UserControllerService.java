package com.example.testest.service;


import com.example.testest.converter.UserConverter;
import com.example.testest.dto.UserDTO;
import com.example.testest.exception.UserLoginNotNullException;
import org.springframework.stereotype.Service;
import com.example.testest.service.data.UserService;

import java.util.List;

@Service
public class UserControllerService {

    private final UserService userService;
    private final UserConverter userConverter;

    public UserControllerService(UserService userService, UserConverter userConverter){
        this.userService = userService;
        this.userConverter = userConverter;
    }

    public List<UserDTO> findAll(){
        return userConverter.convertToListDto(userService.findAll());
    }

    public UserDTO inBlacklistUser(String login){
        if (login == null){
            throw new UserLoginNotNullException("User login is required.");
        }
        return userConverter.convertToDto(userService.blacklistUser(login));
    }

    public UserDTO unBlacklistUser(String login){
        if (login == null){
            throw new UserLoginNotNullException("User login is required.");
        }
        return userConverter.convertToDto(userService.unBlacklistUser(login));
    }
}
