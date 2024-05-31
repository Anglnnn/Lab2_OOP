package com.example.testest.service.data;


import com.example.testest.entity.User;
import com.example.testest.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.testest.repository.ShopUserRepository;

import java.util.Optional;

@Component
public class RegistrationService {

    private final ShopUserRepository shopUserRepository;

    public RegistrationService(ShopUserRepository shopUserRepository){
        this.shopUserRepository = shopUserRepository;
    }

    @Transactional
    public User save(User currentUser){
        Optional<User> oldUser = shopUserRepository.findByLogin(currentUser.getLogin());
        oldUser.ifPresent(entity->{throw new UserAlreadyExistsException("User already exists.");});
        return shopUserRepository.save(currentUser);
    }
}
