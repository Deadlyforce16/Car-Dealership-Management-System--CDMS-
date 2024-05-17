package com.cardealership.vehicle.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping(path = {"/api/vehicles"})
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public Iterable<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok().body(vehicle);
    }



    @GetMapping("/search")
    public List<Vehicle> searchVehiclesByColor(@RequestParam String color) {
        return vehicleService.findVehiclesByColor(color);
    }

    @GetMapping(params = {"sort=price"})
    public ResponseEntity<List<Vehicle>> getVehiclesSortedByPrice(@RequestParam("order") String order) {
        List<Vehicle> sortedVehicles = vehicleService.getAllVehiclesSortedByPrice(order);
        return ResponseEntity.ok().body(sortedVehicles);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle, @RequestParam(required = false) Integer year) {
        if (year != null) {
            vehicle.setYear(year);
        }
        Vehicle createdVehicle = vehicleService.addNewVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
        return ResponseEntity.ok().body(updatedVehicle);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> patchVehicle(@PathVariable Long id, @RequestBody Map<String, Object> partialVehicle) {
        Vehicle patchedVehicle = vehicleService.patchVehicle(id, partialVehicle);
        return ResponseEntity.ok().body(patchedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
