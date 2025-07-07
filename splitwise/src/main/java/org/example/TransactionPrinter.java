package org.example;

import org.example.entity.ReceiverShares;

import java.text.DecimalFormat;
import java.util.Map;

public class TransactionPrinter {
    public TransactionPrinter() {}

    public static void print (Map<String, ReceiverShares> transactions) {
        DecimalFormat df = new DecimalFormat("0.##");

        System.out.println("List of Transactions - ");

        for (Map.Entry<String, ReceiverShares> expense : transactions.entrySet()) {
            String payer = expense.getKey();
            Map<String, Double> receivers = expense.getValue().getShares();

            for (Map.Entry<String, Double> receiverEntry : receivers.entrySet()) {
                String payee = receiverEntry.getKey();
                double amount = receiverEntry.getValue();

                System.out.println(payee + " pays " + payer + " " + df.format(amount));
            }
        }

    }
}
