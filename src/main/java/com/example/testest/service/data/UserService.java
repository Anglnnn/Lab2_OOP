package com.example.testest.service.data;


import com.example.testest.entity.Blacklist;
import com.example.testest.entity.User;
import com.example.testest.exception.UserAlreadyInBlacklistException;
import com.example.testest.exception.UserNotFoundException;
import com.example.testest.exception.UserNotInBlacklistException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.testest.repository.BlacklistRepository;
import com.example.testest.repository.ShopUserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private final ShopUserRepository shopUserRepository;
    private final BlacklistRepository blacklistRepository;

    public UserService(ShopUserRepository shopUserRepository, BlacklistRepository blacklistRepository){
        this.shopUserRepository = shopUserRepository;
        this.blacklistRepository = blacklistRepository;
    }

    public List<User> findAll(){
        return shopUserRepository.findAll();
    }

    @Transactional
    public User blacklistUser (String login){
        Optional<User> user = shopUserRepository.findByLogin(login);
        User u = user.orElseThrow(()-> new UserNotFoundException());

        if (u.getBlacklist() != null){
            throw new UserAlreadyInBlacklistException();
        }

        Blacklist blacklist = new Blacklist();
        blacklist.setUser(u);

        blacklistRepository.save(blacklist);

        return shopUserRepository
                .findByLogin(u.getLogin())
                .orElseThrow(()-> new UserNotFoundException());
    }

    @Transactional
    public User unBlacklistUser(String login){
        Optional<User> user = shopUserRepository.findByLogin(login);
        User u = user.orElseThrow(()-> new UserNotFoundException());

        Blacklist blacklist = u.getBlacklist();

        if(blacklist == null){
            throw new UserNotInBlacklistException();
        }

        u.setBlacklist(null);
        blacklistRepository.delete(blacklist);
        return shopUserRepository
                .findByLogin(u.getLogin())
                .orElseThrow(()-> new UserNotFoundException());
    }


    public Optional<User> findUserByLogin(String login){
        return shopUserRepository.findByLogin(login);
    }
}