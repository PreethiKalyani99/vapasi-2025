package org.example.dao;

import org.example.entity.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCustomerDao {
    private static CustomerDao dao;

    @BeforeAll
    public static void init () {
        dao = new CustomerDao();
    }

    @Test
    public void testSave() {
        Customer c1 = new Customer(1027, "Jacob", "1234567890", 1);
        assertTrue(dao.save(c1));
    }

    @Test
    public void testFindById () {
        Customer c1 = dao.findById(1024);
        assertNotNull(c1);
        System.out.println(c1);
    }

    @Test
    public void testFindAll () {
        List<Customer> c1 = dao.findAll();
        assertTrue(c1.size() > 1);
    }

    @Test
    public void testDelete () {
        boolean c = dao.delete(1026);
        List<Customer> c1 = dao.findAll();
        assertTrue(c1.size() > 1);
    }
}
