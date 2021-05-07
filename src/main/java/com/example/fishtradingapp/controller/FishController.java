package com.example.fishtradingapp.controller;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.service.IFishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class FishController {
    private IFishService fishService;

    @Autowired
    public FishController(IFishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/fish")
    public List<Fish> getAllFish() {
        return fishService.findAll();
    }

    @GetMapping("/fish/{id}")
    public ResponseEntity<Fish> getFishById(@PathVariable int id) {
        return ResponseEntity.ok(fishService.findById(id));
    }

    @PutMapping("/fish/{id}")
    public ResponseEntity<Fish> updateFish(@PathVariable int id, @RequestBody Fish fishDetails) {
        return ResponseEntity.ok(fishService.updateFish(id, fishDetails));
    }

    @DeleteMapping("/fish/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFish(@PathVariable int id) {
        return ResponseEntity.ok(fishService.deleteFish(id));
    }
}