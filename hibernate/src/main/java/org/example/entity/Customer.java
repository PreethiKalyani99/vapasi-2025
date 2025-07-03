package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // annotation help us mapping to the table
@Table(name = "cust")
public class Customer {
    @Id
    @Column(name = "cust_id")
    private int custId;

    @Column(name = "cname", length = 30) // by default it takes 255 for length
    private String custName;

    @Column(length = 10)
    private String mobile;

    @Column
    private double cstrLimit;

    public Customer() {} // we create default customer for reflection purpose

    public Customer(int custId, String custName, String mobile, double cstrLimit) {
        this.custId = custId;
        this.custName = custName;
        this.mobile = mobile;
        this.cstrLimit = cstrLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", cstrLimit=" + cstrLimit +
                '}';
    }
}
