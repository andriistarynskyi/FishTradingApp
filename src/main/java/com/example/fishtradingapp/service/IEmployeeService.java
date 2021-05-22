package com.example.fishtradingapp.service;

import com.example.fishtradingapp.entity.Employee;
import com.example.fishtradingapp.entity.Role;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findByRole(Role role);

    Employee findById(int id);

    Employee updateEmployee(int id, Employee employee);

    Map<String, Boolean> deleteEmployee(int id);

    void save(Employee employee);
}
