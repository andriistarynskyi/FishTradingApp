package com.example.fishtradingapp.entity.dto;

import com.example.fishtradingapp.entity.Role;
import lombok.Data;

@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private String familyName;
    private Role role;
    //    add list of orders and payments


    public EmployeeDTO() {
    }


}
