package org.example.dao;

import org.example.entity.Customer;

import javax.persistence.*;
import java.util.List;
import java.util.Queue;

public class CustomerDao {
    GenericDao dao = new GenericDao("Vapasi");

    public boolean save (Customer cust) {
        return dao.save(cust);
    }

    public Customer findById(int custId) {
        return dao.findById(Customer.class, custId);
    }

    public List<Customer> findAll () {
        return dao.findAll("From Customer");
    }

    public boolean delete (int custId) {
        return dao.delete(Customer.class, custId);
    }
}
