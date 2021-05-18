package com.example.fishtradingapp.entity.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class FishDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortDescription;
    private String description;
    private String imageUrl;
    private double price;

    public FishDTO() {
    }

    public FishDTO(int id, String name,
                   String shortDescription,
                   String description,
                   String imageUrl,
                   double price) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
