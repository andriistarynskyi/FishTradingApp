package com.example.fishtradingapp.utils;

import com.example.fishtradingapp.entity.Fish;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntityValidator {
    public static boolean validateFishForNull(Fish fish) {
        return fish != null;
    }
}