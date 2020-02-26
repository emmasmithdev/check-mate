package com.example.codeclan.CheckMate.repositories;

import com.example.codeclan.CheckMate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
