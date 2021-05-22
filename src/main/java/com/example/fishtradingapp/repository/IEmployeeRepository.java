package com.example.fishtradingapp.repository;

import com.example.fishtradingapp.entity.Employee;
import com.example.fishtradingapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByRole(Role role);
}
