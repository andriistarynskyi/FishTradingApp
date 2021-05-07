package com.example.fishtradingapp.repository;

import com.example.fishtradingapp.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFishRepository extends JpaRepository<Fish, Integer> {
}
