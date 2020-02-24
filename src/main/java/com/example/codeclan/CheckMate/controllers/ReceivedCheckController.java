package com.example.codeclan.CheckMate.controllers;

import com.example.codeclan.CheckMate.models.ReceivedCheck;
import com.example.codeclan.CheckMate.models.enums.CheckAns;
import com.example.codeclan.CheckMate.repositories.ReceivedCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.List;

@RestController
public class ReceivedCheckController {

    @Autowired
    ReceivedCheckRepository receivedCheckRepository;

    @GetMapping(value="/received_checks")
    public ResponseEntity<List<ReceivedCheck>> getAllChecks() {
        return new ResponseEntity<>(receivedCheckRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/received_checks/check_ans")
    public ResponseEntity<EnumMap<CheckAns, String>> getCheckAns() {
        EnumMap<CheckAns, String> allChecks = new EnumMap<>(CheckAns.class);
        for(CheckAns check : CheckAns.values()) {
            allChecks.put(check, check.check);
        }
        return new ResponseEntity<>(allChecks, HttpStatus.OK);
    }

    @GetMapping(value="/received_checks/{id}")
    public ResponseEntity getCheck(@PathVariable Long id) {
        return new ResponseEntity<>(receivedCheckRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/received_checks")
    public ResponseEntity<ReceivedCheck> postCheck(@RequestBody ReceivedCheck check) {
        receivedCheckRepository.save(check);
        return new ResponseEntity<>(check, HttpStatus.CREATED);
    }

    @PatchMapping(value="/received_checks/{id}")
    public ResponseEntity<ReceivedCheck> updateComment(@RequestBody ReceivedCheck check) {
        receivedCheckRepository.save(check);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }

    @DeleteMapping(value="/received_checks/{id}")
    public ResponseEntity<ReceivedCheck> deleteCheck(@PathVariable Long id) {
        ReceivedCheck found = receivedCheckRepository.getOne(id);
        receivedCheckRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
