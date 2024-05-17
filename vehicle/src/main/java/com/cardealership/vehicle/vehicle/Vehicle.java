package com.cardealership.vehicle.vehicle;

import jakarta.persistence.*;
import java.util.Random;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private String color;
    private double price;
    private boolean isNew; // true for new, false for refurbished
    private String licensePlate;
    private int vehicle_year;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, String color, double price, boolean isNew) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.licensePlate = generateLicensePlate();
        this.isNew = isNew;
        this.vehicle_year = generateRandomYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public int getYear() {
        return vehicle_year;
    }

    public void setYear(int year) {
        this.vehicle_year = year;
    }

    private String generateLicensePlate() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int plateLength = 7; // you can adjust the length as needed
        StringBuilder plateBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < plateLength; i++) {
            plateBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }
        return plateBuilder.toString();
    }
    private int generateRandomYear() {
        // generate a random year between 2000 and 2024, adjust as needed
        return new Random().nextInt(25) + 2000;
    }
}
