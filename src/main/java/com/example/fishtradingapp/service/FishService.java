package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.repository.IFishRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FishService implements IFishService {
    private IFishRepository fishRepository;

    public FishService(IFishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    @Override
    public List<Fish> findAll() {
        return fishRepository.findAll();
    }

    @Override
    public Fish findById(int id) {
        return fishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fish not exist with id: " + id));
    }

    @Override
    public Fish updateFish(int id, Fish fishDetails) {
        Fish fish = findById(id);
        fish.setImageUrl(fishDetails.getImageUrl());
        fish.setShortDescription((fishDetails.getShortDescription()));
        fish.setDescription(fishDetails.getDescription());
        fishRepository.save(fish);
        return fish;
    }

    @Override
    public Map<String, Boolean> deleteFish(int id) {
        Fish fish = findById(id);
        fishRepository.delete(fish);
        Map<String, Boolean> response = new HashMap();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}