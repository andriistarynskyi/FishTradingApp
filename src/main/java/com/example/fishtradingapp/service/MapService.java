package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Fish;
import com.example.fishtradingapp.entity.dto.FishDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MapService implements IMapService {
    private final ModelMapper modelMapper;

    @Override
    public FishDTO getFishDto(Fish fish) {
        return modelMapper.map(fish, FishDTO.class);
    }

    @Override
    public Fish getFish(FishDTO fishDTO) {
        return modelMapper.map(fishDTO, Fish.class);
    }
}
