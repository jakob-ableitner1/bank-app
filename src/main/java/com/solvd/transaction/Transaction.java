package com.solvd.transaction;

import com.solvd.account.Account;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Transaction {
    protected Account fromAccount;
    protected Account toAccount;
    protected BigDecimal amount;

    public Transaction(Account fromAccount, Account toAccount, BigDecimal amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public abstract void performTransaction();

    @Override
    public String toString(){
        return "{\"From Account\" : " + fromAccount + ", \"To Account\" : " + toAccount + ", \"Amount\" : " + amount + "}";
    }
}
