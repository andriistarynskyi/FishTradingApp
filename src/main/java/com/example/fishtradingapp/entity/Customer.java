package com.example.fishtradingapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    @Column(name = "family_name")
    private String familyName;
    private String login;
    private String password;
    private String email;

    public Customer() {
    }

    public Customer(int id, String name,
                    String familyName,
                    String login,
                    String password,
                    String email) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.login = login;
        this.password = password;
        this.email = email;
    }
}