package com.joelotfy.marketplace.vehicle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.lang.Boolean;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //delegates id generation entirely to db (SQL: GENERATED AS IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 2500)
    private String description;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false, precision = 12, scale = 2) //precision for digits allowed, scale is for digits on the right of decimal point
    private BigDecimal dailyRate; //use BigDecimal for money

    private Boolean active = true;

    //noargs constructor required by JPA for reflection
    //protected to stay hidden from the rest of my app
    protected Vehicle() {}

    //getters
    public Long getId() {return id;}

    public String getName() {return name;}

    public String getDescription() {return description;}

    public String getCategory() {return category;}

    public BigDecimal getDailyRate() {return dailyRate;}

    public Boolean isActive() {return active;}

    //setters
    public void setId(Long id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setDescription(String description) {this.description = description;}

    public void setCategory(String category) {this.category = category;}

    public void setDailyRate(BigDecimal dailyRate) {this.dailyRate = dailyRate;}

    public void setActive(Boolean active) {this.active = active;}

    //params constructor
    public Vehicle(String name, String description, String category, BigDecimal dailyRate, Boolean active) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.dailyRate = dailyRate;
        this.active = active;
    }
}
