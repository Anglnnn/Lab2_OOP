package com.example.testest.controller;

import com.example.testest.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.testest.service.RegistrationControllerService;

@RestController
@CrossOrigin
public class RegistrationController {
    private final RegistrationControllerService registrationControllerService;

    public RegistrationController(RegistrationControllerService registrationControllerService){
        this.registrationControllerService = registrationControllerService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity registration(@Valid @RequestBody UserDTO userDTO){
        registrationControllerService.save(userDTO);
        return ResponseEntity.accepted().build();
    }
}
