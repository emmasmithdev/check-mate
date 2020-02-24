package com.example.codeclan.CheckMate.controllers;

import com.example.codeclan.CheckMate.models.Post;
import com.example.codeclan.CheckMate.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping(value="/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/posts/{id}")
    public ResponseEntity getPost(@PathVariable Long id) {
        return new ResponseEntity<>(postRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/posts")
    public ResponseEntity<Post> postPost(@RequestBody Post post) {
        postRepository.save(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

<<<<<<< HEAD
=======

>>>>>>> ba0db382d310d53bbebd10d12810481b600b02f9
    @PatchMapping(value="/posts/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        postRepository.save(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(value="/posts/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) {
        Post found = postRepository.getOne(id);
        postRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
