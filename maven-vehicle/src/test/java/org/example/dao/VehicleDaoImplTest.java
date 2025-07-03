package org.example.dao;

import org.example.bean.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleDaoImplTest {
    private VehicleDao vehicleDao;

    @BeforeEach
    void setUp () {
        vehicleDao = new VehicleDaoImpl();
    }

    @Test
    void testAddVehicle () {
        vehicleDao.add(new Vehicle("v1", "Yamaha", "White", "Diesel", 200000, 101));
        assertFalse(vehicleDao.findAll().isEmpty());
    }

    @Test
    void testAvailableCode () {
        Vehicle expectedResult = new Vehicle("v1", "Yamaha", "White", "Diesel", 200000, 101);
        assertEquals(expectedResult, vehicleDao.findByCode(101));
    }
}
