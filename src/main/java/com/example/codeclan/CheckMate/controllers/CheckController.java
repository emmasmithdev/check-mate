package com.example.codeclan.CheckMate.controllers;


import com.example.codeclan.CheckMate.models.Check;
import com.example.codeclan.CheckMate.models.enums.CheckAsk;
import com.example.codeclan.CheckMate.repositories.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

@RestController
public class CheckController {

    @Autowired
    CheckRepository checkRepository;

    @GetMapping(value="/api/checks")
    public ResponseEntity<List<Check>> getAllChecks() {
        return new ResponseEntity<>(checkRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/api/checks/checkask")
    public ResponseEntity<EnumMap<CheckAsk, String>> getCheckAsks() {
        EnumMap<CheckAsk, String> allChecks = new EnumMap<>(CheckAsk.class);
        for(CheckAsk check : CheckAsk.values()) {
            allChecks.put(check, check.check);
        }
        return new ResponseEntity<>(allChecks, HttpStatus.OK);
    }

    @GetMapping(value="/api/checks/{id}")
    public ResponseEntity getCheck(@PathVariable Long id) {
        return new ResponseEntity<>(checkRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/api/checks")
    public ResponseEntity<Check> postCheck(@RequestBody Check check) {
        checkRepository.save(check);
        return new ResponseEntity<>(check, HttpStatus.CREATED);
    }

    @PatchMapping(value="/api/checks/{id}")
    public ResponseEntity<Check> updateComment(@RequestBody Check check) {
        checkRepository.save(check);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }

    @DeleteMapping(value="/api/checks/{id}")
    public ResponseEntity<Check> deleteCheck(@PathVariable Long id) {
        Check found = checkRepository.getOne(id);
        checkRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
