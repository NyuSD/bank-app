package com.jacob;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    BankService bank;
    UUID id;

    @BeforeEach
    void setUp() {
        bank = new BankService();
        id = bank.createAccount().getId();
    }

    @Test
    @DisplayName("Deposit increases balance")
    void depositIncreasesBalance() {
        bank.deposit(id, BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), bank.balance(id));
    }

    @Test
    @DisplayName("Withdraw decreases balance")
    void withdrawDecreasesBalance() {
        bank.deposit(id, BigDecimal.valueOf(75));
        bank.withdraw(id, BigDecimal.valueOf(25));
        assertEquals(BigDecimal.valueOf(50), bank.balance(id));
    }

    @Test
    @DisplayName("Over-withdraw throws")
    void overWithdrawThrows() {
        bank.deposit(id, BigDecimal.valueOf(20));
        assertThrows(InsufficientFundsException.class,
                     () -> bank.withdraw(id, BigDecimal.valueOf(50)));
    }
}
