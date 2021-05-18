package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Customer;
import com.example.fishtradingapp.entity.Fish;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    Customer updateCustomer(int id, Customer customer);

    Map<String, Boolean> deleteCustomer(int id);

    void save(Customer customer);
}
