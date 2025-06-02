package com.jacob;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        var acc = bank.createAccount();
        System.out.printf("Account %s created.%n", acc.getId());

        bank.deposit(acc.getId(), BigDecimal.valueOf(150));
        System.out.printf("Deposited 150, balance=%s%n", bank.balance(acc.getId()));

        bank.withdraw(acc.getId(), BigDecimal.valueOf(40));
        System.out.printf("Withdrew 40, balance=%s%n", bank.balance(acc.getId()));
    }
}
