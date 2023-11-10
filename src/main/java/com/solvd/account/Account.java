package com.solvd.account;

import com.solvd.exception.OverdraftException;
import com.solvd.profile.MemberProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public abstract class Account {
    private int accountNumber;
    private BigDecimal balance;


    public Account(int accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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

    public abstract String toString();
}
