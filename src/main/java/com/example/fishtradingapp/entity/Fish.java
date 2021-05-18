package com.example.fishtradingapp.entity;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortDescription;
    private String description;
    private String imageUrl;
    @Nullable
    private int quantity;
    @Column(name = "purchased_price")
    @Nullable
    private double purchasedPrice;
    private double price;

    public Fish() {
    }

    public Fish(String name,
                String shortDescription,
                String description,
                String imageUrl,
                double purchasedPrice,
                double price) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.imageUrl = imageUrl;
        this.purchasedPrice = purchasedPrice;
        this.price = price;
    }
}