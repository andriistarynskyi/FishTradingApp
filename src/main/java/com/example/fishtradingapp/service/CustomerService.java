package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Customer;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.repository.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer doesn't exist with id: " + id));
    }

    @Override
    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customer = findById(id);
        customer.setName(customerDetails.getName());
        customer.setFamilyName(customerDetails.getFamilyName());
        customer.setEmail(customerDetails.getEmail());
        return customer;
    }

    @Override
    public Map<String, Boolean> deleteCustomer(int id) {
        Map<String, Boolean> response = new HashMap<>();
        Customer customer = findById(id);
        customerRepository.delete(customer);
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}