package com.example.fishtradingapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FishParcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name = "ordered_fish",
            joinColumns = {@JoinColumn(name = "fish_parcel_id")},
            inverseJoinColumns = {@JoinColumn(name = "fish_id")})
    private List<Fish> fishList;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private boolean isApprovedByGM;
    private FishParcelStatus fishParcelStatus;

    public FishParcel() {
    }


}
