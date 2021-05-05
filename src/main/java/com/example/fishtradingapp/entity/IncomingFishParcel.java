package com.example.fishtradingapp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "incoming_fish_parcel")
public class IncomingFishParcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "parcel_received")
    private LocalDate parcelReceived;
    @ManyToMany
    @JoinTable(name = "incoming_fish_parcels_received",
    joinColumns = {@JoinColumn(name = "incoming_fish_parcel_id")},
    inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private List<Employee> employeeList;
}
