package com.example.fishtradingapp.controller;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.entity.dto.FishDTO;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.service.IFishService;
import com.example.fishtradingapp.service.IMapService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
@AllArgsConstructor
public class FishController {
    private final IFishService fishService;
    private final IMapService mapService;

    @GetMapping("/fish")
    public ResponseEntity<List<FishDTO>> getAllFish() {
        try {
            log.info("Fish controller uses fishService.findAll()");
            return new ResponseEntity<>(fishService.findAll()
                    .stream()
                    .map(mapService::getFishDto)
                    .collect(Collectors.toList()),
                    HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Fish controller is not able to get list of fish.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/fish")
    public ResponseEntity<Fish> addNewFish(@RequestBody FishDTO fishDto) {
        try {
            Fish fish = mapService.getFish(fishDto);
            fishService.save(fish);
            log.info("New fish was added to DB");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Fish entity cannot be saved");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fish/{id}")
    public ResponseEntity<FishDTO> getFishById(@PathVariable int id) {
        try {
            log.info("Fish with id " + id + " was found successfully.");
            return new ResponseEntity<>(mapService.getFishDto(fishService.findById(id)), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Fish with id " + id + " does not exist.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/fish/{id}")
    public ResponseEntity<Fish> updateFish(@PathVariable int id, @RequestBody FishDTO fishDtoDetails) {
        try {
            log.info("Fish with id " + id + " was found successfully.");
            Fish fishDetails = mapService.getFish(fishDtoDetails);
            return new ResponseEntity<>((Fish) fishService.updateFish(id, fishDetails), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Fish with id " + id + " does not exist.");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/fish/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFish(@PathVariable int id) {
        try {
            log.info("Fish with id " + id + " was deleted successfully");
            return new ResponseEntity<>(fishService.deleteFish(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            log.error("Fish with id " + id + " is not exist", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}