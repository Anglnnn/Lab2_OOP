package com.example.testest.repository;

import com.example.testest.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
}
