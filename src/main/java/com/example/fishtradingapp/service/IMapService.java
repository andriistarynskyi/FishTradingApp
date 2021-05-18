package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.entity.dto.FishDTO;

public interface IMapService {
    FishDTO getFishDto(Fish fish);

    Fish getFish(FishDTO fishDTO);
}
