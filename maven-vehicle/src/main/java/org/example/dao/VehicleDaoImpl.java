package notes.streams.dao;

import notes.streams.Vehicle;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleDaoImpl  implements VehicleDao{
    private List<Vehicle> vehicles;

    public VehicleDaoImpl() {
        Stream<String> lines = Files.lines(Paths.get("streams/dao/vehicles.txt"));

        lines.map(line -> {

        });
        vehicles = new ArrayList<>();
    }

    @Override
    public boolean add(Vehicle vehicle) {
        vehicles.add(vehicle);
        return true;
    }

    @Override
    public Vehicle findByCode(int code) {
        return vehicles.stream().filter(v -> v.getCode() == code).findFirst().orElse(null);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return vehicles.stream().filter(v -> v.getColor().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        return vehicles.stream().filter(v -> v.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByModel(String model) {
        return vehicles.stream().filter(v -> v.getColor().equals(model)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByFuel(String fuel) {
        return vehicles.stream().filter(v -> v.getColor().equals(fuel)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByCostRange(double min, double max) {
        return vehicles.stream().filter(v -> (v.getCost() >= min) && (v.getCost() <= max)).collect(Collectors.toList());
    }
}
