package org.example.service;

import org.example.entity.Expense;
import org.example.entity.ReceiverShares;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ShareCalculatorTest {
    @Test
    void shouldCalculateShareForSingleExpenseSingleReceiver () {
        Expense expense = new Expense("A", 100, new String[]{"B"});
        Map<String, ReceiverShares> transaction = ShareCalculator.calculate(List.of(expense));

        assertEquals(1, transaction.size());
        ReceiverShares shares = transaction.get("A");
        assertEquals(100, shares.getShares().get("B"));
    }

    @Test
    void shouldCalculateShareForSingleExpenseMultipleReceivers () {
        Expense expense = new Expense("A", 600, new String[]{"A","B", "C"});
        Map<String, ReceiverShares> transactions = ShareCalculator.calculate(List.of(expense));

        assertEquals(1, transactions.size());
        ReceiverShares shares = transactions.get("A");
        assertEquals(200, shares.getShares().get("B"));
        assertEquals(200, shares.getShares().get("C"));
        assertNull(shares.getShares().get("A"));
    }

    @Test
    void shouldCalculateSharesForMultipleExpenseMultipleReceivers () {
        List<Expense> expenses = List.of(
                new Expense("A", 100, new String[]{"A", "B", "C"}),
                new Expense("B", 60, new String[]{"C", "D"})
        );
        Map<String, ReceiverShares> transactions = ShareCalculator.calculate(expenses);

        assertEquals(2, transactions.size());

        assertEquals(33, round(transactions.get("A").getShares().get("B")));
        assertEquals(33, round(transactions.get("A").getShares().get("C")));

        assertEquals(30, transactions.get("B").getShares().get("C"));
        assertEquals(30, transactions.get("B").getShares().get("D"));
    }
}
