package com.example.fishtradingapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
    private int name;
    @Column(name = "s_name")
    private int sName;

    public Customer() {
    }

    public Customer(int name, int sName) {
        this.name = name;
        this.sName = sName;
    }
}