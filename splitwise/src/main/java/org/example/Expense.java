package org.example;

import java.util.Arrays;

public class Expense {
    private String spender;
    private double amount;
    private String[] receivers;

    public Expense() {}

    public Expense(String spender, double amount, String[] receivers) {
        this.spender = spender;
        this.amount = amount;
        this.receivers = receivers;
    }

    public String getSpender() {
        return spender;
    }

    public double getAmount() {
        return amount;
    }

    public String[] getReceivers() {
        return receivers;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "spender='" + spender + '\'' +
                ", amount=" + amount +
                ", receivers=" + Arrays.toString(receivers) +
                '}';
    }
}
