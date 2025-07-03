package org.example.dao;

import org.example.bean.Vehicle;
import org.example.util.OutOfStockException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleDaoImpl  implements VehicleDao{
    private List<Vehicle> vehicles;

    public VehicleDaoImpl() {
//        Stream<String> lines = Files.lines(Paths.get("streams/dao/vehicles.txt"));
//
//        lines.map(line -> {
//
//        });
        vehicles = new ArrayList<>();
    }

    @Override
    public boolean add(Vehicle vehicle) {
        vehicles.add(vehicle);
        return true;
    }

    @Override
    public Vehicle findByCode(int code) {
        Vehicle availableVehicles = vehicles.stream().filter(v -> v.getCode() == code).findFirst().orElse(null);

        if(availableVehicles == null) {
            throw new OutOfStockException("Code is out of stock");
        }
        return availableVehicles;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        List<Vehicle> availableVehicles = vehicles.stream().filter(v -> v.getColor().equals(brand)).collect(Collectors.toList());

        if(availableVehicles.isEmpty()) {
            throw new OutOfStockException("Brand is out of stock");
        }

        return availableVehicles;
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        List<Vehicle> availableVehicles = vehicles.stream().filter(v -> v.getColor().equals(color)).collect(Collectors.toList());

        if(availableVehicles.isEmpty()) {
            throw new OutOfStockException("Color is out of stock");
        }
        return availableVehicles;
    }

    @Override
    public List<Vehicle> findByModel(String model) {
        List<Vehicle> availableVehicles = vehicles.stream().filter(v -> v.getColor().equals(model)).collect(Collectors.toList());

        if(availableVehicles.isEmpty()) {
            throw new OutOfStockException("Model is out of stock");
        }
        return availableVehicles;
    }

    @Override
    public List<Vehicle> findByFuel(String fuel) {
        List<Vehicle> availableVehicles = vehicles.stream().filter(v -> v.getColor().equals(fuel)).collect(Collectors.toList());

        if(availableVehicles.isEmpty()) {
            throw new OutOfStockException("Fuel is out of stock");
        }
        return availableVehicles;
    }

    @Override
    public List<Vehicle> findByCostRange(double min, double max) {
        List<Vehicle> availableVehicles = vehicles.stream().filter(v -> (v.getCost() >= min) && (v.getCost() <= max)).collect(Collectors.toList());

        if(availableVehicles.isEmpty()) {
            throw new OutOfStockException("Vehicles range from " + min + " to " + max + " is out of stock");
        }
        return availableVehicles;
    }
}
