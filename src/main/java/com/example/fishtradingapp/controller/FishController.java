package com.example.fishtradingapp.controller;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.service.IFishService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
@AllArgsConstructor
public class FishController {
    private final IFishService fishService;

    @GetMapping("/fish")
    public ResponseEntity<List<Fish>> getAllFish() {
        try {
            log.info("Fish controller uses fishService.findAll()");
            return new ResponseEntity<>(fishService.findAll(), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Fish controller is not able to get list of fish.");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fish/{id}")
    public ResponseEntity<Fish> getFishById(@PathVariable int id) {
        try {
            log.info("Fish with id " + id + " was found successfully.");
            return new ResponseEntity<>(fishService.findById(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Fish with id " + id + " does not exist.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/fish/{id}")
    public ResponseEntity<Fish> updateFish(@PathVariable int id, @RequestBody Fish fishDetails) {
        try {
            log.info("Fish with id " + id + " was found successfully.");
            return new ResponseEntity<>(fishService.updateFish(id, fishDetails), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Fish with id " + id + " does not exist.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/fish/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFish(@PathVariable int id) {
        try {
            log.info("Fish with id " + id + " was deleted successfully");
            return new ResponseEntity<>(fishService.deleteFish(id), HttpStatus.OK);
        } catch(ResourceNotFoundException e) {
            log.error("Fish with id " + id + " is not exist", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}