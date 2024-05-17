package com.cardealership.vehicle.vehicle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VehicleConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            VehicleRepository repository) {
        return args -> {
            Vehicle car1 = new Vehicle(
                    "Civic",
                    "Honda",
                    "Red",
                    25000.00,
                    true
            );

            Vehicle car2 = new Vehicle(
                    "Corolla",
                    "Toyota",
                    "Blue",
                    23000.00,
                    true
            );

            Vehicle car3 = new Vehicle(
                    "Raptor",
                    "Ford",
                    "Black",
                    50000.00,
                    true
            );

            Vehicle car4 = new Vehicle(
                    "Challenger",
                    "Dodge",
                    "Orange",
                    18000.00,
                    true
            );

            Vehicle car5 = new Vehicle(
                    "Yugo",
                    "Zastava",
                    "Brown",
                    500.00,
                    true
            );

            Vehicle car6 = new Vehicle(
                    "Camaro",
                    "Chevrolet",
                    "Yellow",
                    30000.00,
                    true
            );

            Vehicle car7 = new Vehicle(
                    "Corsa Electric",
                    "Opel",
                    "Silver",
                    120000.00,
                    true
            );

            Vehicle car8 = new Vehicle(
                    "Wrangler",
                    "Jeep",
                    "Dark Green",
                    12000.00,
                    true
            );

            Vehicle car9 = new Vehicle(
                    "300",
                    "Chrysler",
                    "White",
                    22000.00,
                    true
            );

            Vehicle car10 = new Vehicle(
                    "Fiero",
                    "Pontiac",
                    "Red",
                    15000.00,
                    true
            );

            repository.saveAll(
                    List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10)
            );
        };
    }
}
