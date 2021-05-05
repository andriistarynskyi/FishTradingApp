package com.example.fishtradingapp.entity;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sum_paid")
    private double sumPaid;
    @ManyToOne
    @JoinColumn(name = "fish_parcel_id")
    private FishParcel fishParcel;
}
