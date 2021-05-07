package com.example.fishtradingapp.repository;

import com.example.fishtradingapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
