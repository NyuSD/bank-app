package com.jacob;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents a bank account with a unique identifier and a balance.
 * Provides methods to get the account ID and balance, and to set a new balance.
 */

public class Account {
    private final UUID id;
    private BigDecimal balance;

    public Account() {
        this.id = UUID.randomUUID();
        this.balance = BigDecimal.ZERO;
    }

    public UUID getId() { return id; }

    public BigDecimal getBalance() { return balance; }

    /**
     * Sets a new balance for the account.
     *
     * @param newBalance the new balance to set
     */
    
    void setBalance(BigDecimal newBalance) {
        this.balance = newBalance;
    }
}