package com.example.fishtradingapp.controller;

import com.example.fishtradingapp.entity.Employee;
import com.example.fishtradingapp.entity.dto.EmployeeDTO;
import com.example.fishtradingapp.exception.ResourceNotFoundException;
import com.example.fishtradingapp.service.IEmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")
@Slf4j
@AllArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        try {
            List<EmployeeDTO> employeeDTOs = employeeService.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, EmployeeDTO.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable int id) {
        try {
            EmployeeDTO employeeDTO = modelMapper.map(employeeService.findById(id), EmployeeDTO.class);
            return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody EmployeeDTO employeeDto) {
        try {
            Employee employee = modelMapper.map(employeeDto, Employee.class);
            employeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,
                                                   @RequestBody EmployeeDTO employeeDtoDetails) {
        try {
            Employee employeeDetails = modelMapper.map(employeeDtoDetails, Employee.class);
            return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDetails), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable int id) {
        Map<String, Boolean> response = new HashMap<>();
        employeeService.deleteEmployee(id);
        response.put("Employee deleted", Boolean.TRUE);
        return response;
    }
}