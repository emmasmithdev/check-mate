package com.example.codeclan.CheckMate.repositories;

import com.example.codeclan.CheckMate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
