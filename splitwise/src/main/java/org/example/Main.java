package org.example;

import org.example.entity.Expense;
import org.example.entity.ReceiverShares;
import org.example.service.ShareCalculator;
import org.example.service.ExpenseParser;

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