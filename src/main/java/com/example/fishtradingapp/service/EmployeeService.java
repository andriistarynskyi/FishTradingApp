package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Employee;
import com.example.fishtradingapp.entity.Role;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.repository.IEmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByRole(Role role) {
        return employeeRepository.findByRole(role);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " was not found"));
    }

    @Override
    public Employee updateEmployee(int id, Employee employeeDetails) {
        Employee employee = findById(id);
        employee.setName(employeeDetails.getName());
        employee.setFamilyName(employeeDetails.getFamilyName());
        employee.setRole(employeeDetails.getRole());
        save(employee);
        return employee;
    }

    @Override
    public Map<String, Boolean> deleteEmployee(int id) {
        Map<String, Boolean> response = new HashMap<>();
        Employee employee = findById(id);
        employeeRepository.delete(employee);
        response.put("Employee", Boolean.TRUE);
        return null;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}