package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public class ReceiverShares {
    private final Map<String, Double> receiverShare = new HashMap<>();

    public ReceiverShares() {}

    public void add(String receiver, double amount) {
        receiverShare.merge(receiver, amount, Double::sum);
    }

    public Map<String, Double> getShares() {
        return receiverShare;
    }

    @Override
    public String toString() {
        return "ReceiverShare{" +
                "receiverShare=" + receiverShare +
                '}';
    }
}
