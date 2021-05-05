package com.example.fishtradingapp.entity;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int name;
    @Column(name = "s_name")
    private int sName;

}
