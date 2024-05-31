package com.example.testest.repository;


import com.example.testest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
