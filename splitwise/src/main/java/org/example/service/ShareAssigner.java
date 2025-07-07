package org.example.service;

import org.example.entity.Expense;
import org.example.entity.ReceiverShares;

import java.util.Map;

public class ShareAssigner {
    public ShareAssigner() {}

    public static void assign (double share, Expense expense, Map<String, ReceiverShares> transactions) {
        String spender = expense.getSpender();
        ReceiverShares receiverShares = transactions.computeIfAbsent(spender, k -> new ReceiverShares());

        for (String receiver : expense.getReceivers()) {
            if (receiver.equals(expense.getSpender())) continue;

            receiverShares.add(receiver.trim(), share);
        }
    }
}
