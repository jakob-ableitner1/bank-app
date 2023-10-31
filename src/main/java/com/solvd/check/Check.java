package com.solvd.check;

import java.math.BigDecimal;

public class Check {
    private int fromAccountNumber;
    private int toAccountNumber;
    private BigDecimal amount;
    private boolean hasVerification;

    public Check(int fromAccountNumber, int toAccountNumber, BigDecimal amount, boolean hasVerification) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.hasVerification = hasVerification;
    }

    public int getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(int fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public int getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(int toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isHasVerification() {
        return hasVerification;
    }

    public void setHasVerification(boolean hasVerification) {
        this.hasVerification = hasVerification;
    }
}
