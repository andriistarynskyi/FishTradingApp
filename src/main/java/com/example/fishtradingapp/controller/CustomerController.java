package com.example.fishtradingapp.controller;

import com.example.fishtradingapp.entity.Customer;
import com.example.fishtradingapp.entity.dto.CustomerDTO;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
@AllArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>> getAll() {
        try {
            List<CustomerDTO> customerDTOs = customerService.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, CustomerDTO.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            Customer customer = modelMapper.map(customerDTO, Customer.class);
            customerService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        try {
            Customer customer = customerService.findById(id);
            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id,
                                                   @RequestBody CustomerDTO customerDtoDetails) {
        try {
            Customer customerDetails = modelMapper.map(customerDtoDetails, Customer.class);
            return new ResponseEntity<>(customerService.updateCustomer(id, customerDetails), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable int id) {
        try {
            return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}