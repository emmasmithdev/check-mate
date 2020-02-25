package com.example.codeclan.CheckMate.controllers;

import com.example.codeclan.CheckMate.models.News;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NewsController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/news")
    public News news(@RequestParam(required=false, defaultValue="Empty") String url) {
        return new News(String.format(url));
    }

}
