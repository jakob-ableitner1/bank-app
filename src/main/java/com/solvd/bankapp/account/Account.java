package com.solvd.bankapp.account;

import com.solvd.bankapp.exception.OverdraftException;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Account {

    public final UUID ACCOUNT_NUMBER;
    private BigDecimal balance;

    {
        ACCOUNT_NUMBER = UUID.randomUUID();
    }

    public Account(){
        UUID accountNumber = UUID.randomUUID();
    }

    public Account(BigDecimal balance) {
        this.balance = balance;
        UUID accountNumber = UUID.randomUUID();
    }

    public UUID getAccountNumber() {
        return ACCOUNT_NUMBER;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public abstract boolean withdrawal(BigDecimal amount) throws OverdraftException;
}
