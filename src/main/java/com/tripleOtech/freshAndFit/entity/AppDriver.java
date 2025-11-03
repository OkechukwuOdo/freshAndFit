package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class AppDriver {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    private String vehicleNumber;

    @OneToMany(mappedBy = "driver")
    private List<Delivery> deliveries = new ArrayList<>();
}
