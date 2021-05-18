package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.repository.IFishRepository;
import com.example.fishtradingapp.utils.EntityValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class FishService implements IFishService {
    private final IFishRepository fishRepository;

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
    public Map<String, Boolean> updateFish(int id, Fish fishDetails) {
        Map<String, Boolean> response = new HashMap<>();
        if (!EntityValidator.validateFishForNull(fishDetails)) {
            Fish fish = findById(id);
            fish.setImageUrl(fishDetails.getImageUrl());
            fish.setShortDescription((fishDetails.getShortDescription()));
            fish.setDescription(fishDetails.getDescription());
            fishRepository.save(fish);
            response.put("Update", Boolean.TRUE);
        } else {
            response.put("Update", Boolean.FALSE);
        }
        return response;
    }

    @Override
    public Map<String, Boolean> deleteFish(int id) {
        Fish fish = findById(id);
        fishRepository.delete(fish);
        Map<String, Boolean> response = new HashMap();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @Override
    @Transactional
    public void save(Fish fish) {
        fishRepository.save(fish);
    }
}