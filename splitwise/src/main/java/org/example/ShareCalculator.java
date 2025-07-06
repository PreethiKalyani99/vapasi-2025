package org.example;

import java.util.*;

public class ShareCalculator {

    public ShareCalculator() {}

    public static Map<String, ReceiverShares> calculate(List<Expense> expenses) {

        Map<String, ReceiverShares> transactions = new HashMap<>();

        for (Expense expense : expenses) {
            double share = expense.getAmount() / expense.getReceivers().length;

            ShareAssigner.assign(share, expense, transactions);
        }
        return transactions;
    }
}
