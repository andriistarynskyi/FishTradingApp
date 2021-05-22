package com.example.fishtradingapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "family_name")
    private String familyName;
    private Role role;
    private String login;
    private String password;
    private String email;
//    @OneToMany
//    private List<FishParcel> fishParcelList;


    public Employee() {
    }
}
