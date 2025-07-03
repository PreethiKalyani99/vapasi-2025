package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")

public class Student {
    @Id
    @Column(name = "roll_no")
    private int rollNo;

    @Column(name = "name", length = 30)
    private String name;

    @Column
    private String branch;

    @Column
    private double percentage;

    public Student() {}

    public Student(int rollNo, String name, String branch, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
