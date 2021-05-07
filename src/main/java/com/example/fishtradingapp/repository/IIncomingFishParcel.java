package com.example.fishtradingapp.repository;

import com.example.fishtradingapp.entity.IncomingFishParcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIncomingFishParcel extends JpaRepository<IncomingFishParcel, Integer> {
}
