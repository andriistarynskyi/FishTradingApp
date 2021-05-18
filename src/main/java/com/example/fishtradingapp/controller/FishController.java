package com.example.fishtradingapp.controller;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.entity.dto.FishDTO;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.service.IFishService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/fish")
@Slf4j
@AllArgsConstructor
public class FishController {
    private final IFishService fishService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public ResponseEntity<List<FishDTO>> getAllFish() {
        try {
            List<FishDTO> fishDTOs = fishService.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, FishDTO.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(fishDTOs, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Fish> addNewFish(@RequestBody FishDTO fishDto) {
        try {
            Fish fish = modelMapper.map(fishDto, Fish.class);
            fishService.save(fish);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FishDTO> getFishById(@PathVariable int id) {
        try {
            Fish fish = fishService.findById(id);
            return new ResponseEntity<>(modelMapper.map(fish, FishDTO.class), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Fish> updateFish(@PathVariable int id, @RequestBody FishDTO fishDtoDetails) {
        try {
            Fish fishDetails = modelMapper.map(fishDtoDetails, Fish.class);
            return new ResponseEntity<>(fishService.updateFish(id, fishDetails), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFish(@PathVariable int id) {
        try {
            return new ResponseEntity<>(fishService.deleteFish(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}