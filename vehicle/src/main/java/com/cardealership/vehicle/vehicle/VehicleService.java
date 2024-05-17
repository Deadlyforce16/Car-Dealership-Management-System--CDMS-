package com.cardealership.vehicle.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Iterable<Vehicle> getAllVehicles() {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        if (!vehicles.iterator().hasNext()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No vehicles found");
        }
        return vehicles;
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle with id " + id + " not found"));
    }

    public Vehicle addNewVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle to add was not provided");
        }
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle vehicle = getVehicleById(id);
        if (updatedVehicle == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Updated vehicle details were not provided");
        }
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setBrand(updatedVehicle.getBrand());
        vehicle.setColor(updatedVehicle.getColor());
        vehicle.setPrice(updatedVehicle.getPrice());
        vehicle.setLicensePlate(updatedVehicle.getLicensePlate());
        vehicle.setNew(updatedVehicle.isNew());
        return vehicleRepository.save(vehicle);
    }

    public Vehicle patchVehicle(Long id, Map<String, Object> updates) {
        Vehicle vehicle = getVehicleById(id);
        if (updates == null || updates.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No updates were provided");
        }
        applyUpdates(vehicle, updates);
        return vehicleRepository.save(vehicle);
    }

    private void applyUpdates(Vehicle vehicle, Map<String, Object> updates) {
        updates.forEach((key, value) -> {
            switch (key) {
                case "model":
                    vehicle.setModel((String) value);
                    break;
                case "brand":
                    vehicle.setBrand((String) value);
                    break;
                case "color":
                    vehicle.setColor((String) value);
                    break;
                case "price":
                    vehicle.setPrice((Double) value);
                    break;
                case "licensePlate":
                    vehicle.setLicensePlate((String) value);
                    break;
                case "isNew":
                    vehicle.setNew((Boolean) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
    }

    public List<Vehicle> findVehiclesByColor(String color) {
        List<Vehicle> vehicles = vehicleRepository.findByColor(color);
        if (vehicles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No vehicles found with color " + color);
        }
        return vehicles;
    }

    public List<Vehicle> getAllVehiclesSortedByPrice(String order) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        }
        List<Vehicle> vehicles = vehicleRepository.findAll(Sort.by(direction, "price"));
        if (vehicles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No vehicles found");
        }
        return vehicles;
    }

    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle with id " + id + " not found");
        }
        vehicleRepository.deleteById(id);
    }
}
