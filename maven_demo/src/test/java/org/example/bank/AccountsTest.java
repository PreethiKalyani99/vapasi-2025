package org.example.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountsTest {
    private Accounts accounts;

    @BeforeEach
    void setUp() {
        accounts = new Accounts(1000);
    }

    @Test
    void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> accounts.deposit(-1));
    }

    @Test
    void testValidDeposit() {
        assertEquals(1500, accounts.deposit(500));
    }

    @Test
    void testNegativeWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> accounts.withdraw(-1500));
    }

    @Test
    void testInvalidWithdraw() {
        assertThrows(BalanceException.class, () -> accounts.withdraw(2500));
    }

    @Test
    void testValidWithdraw() throws BalanceException {
        assertEquals(500, accounts.withdraw(500));
    }
}
