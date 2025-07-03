package org.example;


import org.example.bean.Vehicle;
import org.example.dao.VehicleDao;
import org.example.dao.VehicleDaoImpl;
import org.example.service.VehicleService;
import org.example.service.VehicleServiceImpl;

public class TestVehicleService {
    public static void main(String[] args) {
        VehicleDao dao = new VehicleDaoImpl();

        VehicleService service = new VehicleServiceImpl(dao);

        service.add(new Vehicle("v1", "Yamaha", "White", "Diesel", 200000, 101));
        service.add(new Vehicle("v2", "BMW", "Black", "Diesel", 400000, 102));
        service.add(new Vehicle("v3", "AUDI", "Silver", "Diesel", 600000, 103));

        service.findAll().forEach(System.out::println);
    }
}
