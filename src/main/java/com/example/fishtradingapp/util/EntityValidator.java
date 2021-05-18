package com.example.fishtradingapp.util;

import com.example.fishtradingapp.entity.Fish;

public class EntityValidator {
    public static boolean validateFishForNull(Fish fish) {
        return fish != null;
    }
}