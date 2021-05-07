package com.example.fishtradingapp.repository;

import com.example.fishtradingapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
