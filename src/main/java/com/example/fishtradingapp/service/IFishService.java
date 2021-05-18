package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Fish;

import java.util.List;
import java.util.Map;

public interface IFishService {
    List<Fish> findAll();

    Fish findById(int id);

    Map<String, Boolean> updateFish(int id, Fish fish);

    Map<String, Boolean> deleteFish(int id);

    void save(Fish fish);
}
