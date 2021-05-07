package com.example.fishtradingapp.repository;

import com.example.fishtradingapp.entity.FishParcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFishParcelRepository extends JpaRepository<FishParcel, Integer> {
}
