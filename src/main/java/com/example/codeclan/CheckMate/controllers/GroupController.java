package com.example.codeclan.CheckMate.controllers;

import com.example.codeclan.CheckMate.models.Group;
import com.example.codeclan.CheckMate.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping(value="/groups")
    public ResponseEntity<List<Group>> getAllGroups() {
        return new ResponseEntity<>(groupRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/groups/{id}")
    public ResponseEntity<Optional<Group>> getGroup(@PathVariable Long id) {
        return new ResponseEntity<>(groupRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/groups")
    public ResponseEntity<Group> postGroup(@RequestBody Group group) {
        groupRepository.save(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @PatchMapping(value="/groups/{id}")
    public ResponseEntity<Group> updateGroup(@RequestBody Group group) {
        groupRepository.save(group);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @DeleteMapping(value="/groups/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Long id) {
        Group found = groupRepository.getOne(id);
        groupRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
