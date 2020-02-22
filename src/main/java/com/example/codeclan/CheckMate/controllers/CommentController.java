package com.example.codeclan.CheckMate.controllers;

import com.example.codeclan.CheckMate.models.Comment;
import com.example.codeclan.CheckMate.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping(value="/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="comments/{id}")
    public ResponseEntity<Optional<Comment>> getComment(@PathVariable Long id) {
        return new ResponseEntity<>(commentRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/comments")
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @PatchMapping(value="comments/{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping(value="comments/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
        Comment found = commentRepository.getOne(id);
        commentRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
