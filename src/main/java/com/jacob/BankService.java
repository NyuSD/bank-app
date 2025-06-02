package com.jacob;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    private final Map<UUID, Account> accounts = new ConcurrentHashMap<>();

    public Account createAccount() {
        Account acc = new Account();
        accounts.put(acc.getId(), acc);
        return acc;
    }

    public BigDecimal deposit(UUID accountId, BigDecimal amount) {
        validateAmount(amount);
        Account acc = get(accountId);
        acc.setBalance(acc.getBalance().add(amount));
        return acc.getBalance();
    }

    public BigDecimal withdraw(UUID accountId, BigDecimal amount) {
        validateAmount(amount);
        Account acc = get(accountId);
        BigDecimal newBalance = acc.getBalance().subtract(amount);
        if (newBalance.signum() < 0) {
            throw new InsufficientFundsException("Balance cannot go negative");
        }
        acc.setBalance(newBalance);
        return newBalance;
    }

    public BigDecimal balance(UUID accountId) {
        return get(accountId).getBalance();
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    private Account get(UUID id) {
        Account acc = accounts.get(id);
        if (acc == null) throw new IllegalArgumentException("Unknown account");
        return acc;
    }
}
