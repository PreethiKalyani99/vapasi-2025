package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<Expense> expenses = ExpenseParser.parseFile("splitwise/src/main/java/org/example/input");

            Map<String, ReceiverShares> transactions = ShareCalculator.calculate(expenses);

            TransactionPrinter.print(transactions);
        }
        catch (RuntimeException e) {
            System.out.println("Error: " + e);
        }
    }
}