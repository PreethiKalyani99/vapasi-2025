package org.example;

public class Vehicle {
    private String model;
    private String brand;
    private String color;
    private String fuel;
    private double cost;
    private int code;

    public Vehicle () {}

    public Vehicle(String model, String brand, String color, String fuel, double cost, int code) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.fuel = fuel;
        this.cost = cost;
        this.code = code;
    }

    @Override
    public String toString() {
        return
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", fuel='" + fuel + '\'' +
                ", cost=" + cost +
                ", code=" + code;
    }

    public int getCode () {
        return code;
    }

    public String getModel () {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
