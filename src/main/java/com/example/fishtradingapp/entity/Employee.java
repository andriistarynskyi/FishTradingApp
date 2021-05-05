package com.example.fishtradingapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int name;
    @Column(name = "full_name")
    private int fullName;
    private Role role;
    private String login;
    private String password;
    private String email;
    @ManyToMany
    @JoinTable(name = "fish_parcel_placed",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "fish_parcel_id")})
    private List<FishParcel> fishParcelList;

}
