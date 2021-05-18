package com.example.fishtradingapp.entity.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private int id;
    private String name;
    private String familyName;

    public CustomerDTO() {
    }

    public CustomerDTO(String familyName) {
        this.familyName = familyName;
    }
}
