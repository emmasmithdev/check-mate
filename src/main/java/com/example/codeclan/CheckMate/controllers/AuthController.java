package com.example.codeclan.CheckMate.controllers;

import com.example.codeclan.CheckMate.models.User;
import com.example.codeclan.CheckMate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/login_auth")
    public String authorise() {
        return "hello";
    }
}
