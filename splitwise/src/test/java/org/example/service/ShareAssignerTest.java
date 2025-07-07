package org.example.service;

import org.example.entity.Expense;
import org.example.entity.ReceiverShares;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShareAssignerTest {

    Map<String, ReceiverShares> transactions = new HashMap<>();

    @Test
    void shouldAssignShareToEachReceiver () {
        Expense expense = new Expense("A", 60, new String[]{"B", "C"});

        ShareAssigner.assign(30, expense, transactions);

        ReceiverShares shares = transactions.get("A");

        assertEquals(30, shares.getShares().get("B"));
        assertEquals(30, shares.getShares().get("C"));
    }

    @Test
    void shouldSkipSpenderInReceivers () {
        Expense expense = new Expense("A", 90, new String[]{"A", "B", "C"});

        ShareAssigner.assign(30, expense, transactions);

        ReceiverShares shares = transactions.get("A");

        assertNull(shares.getShares().get("A"));
        assertEquals(30, shares.getShares().get("B"));
        assertEquals(30, shares.getShares().get("C"));
    }

    @Test
    void shouldAddToExistingReceiverShare () {
        Expense expense1 = new Expense("A", 60, new String[]{"B", "C"});
        Expense expense2 = new Expense("A", 40, new String[]{"B"});

        ShareAssigner.assign(30, expense1, transactions);
        ShareAssigner.assign(40, expense2, transactions);

        ReceiverShares shares = transactions.get("A");

        assertEquals(70, shares.getShares().get("B"));
        assertEquals(30, shares.getShares().get("C"));
    }
}
