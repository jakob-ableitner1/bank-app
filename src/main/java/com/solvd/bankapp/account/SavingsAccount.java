package com.solvd.bankapp.account;

import com.solvd.bankapp.exception.OverdraftException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

    private static final Logger LOGGER = LogManager.getLogger(SavingsAccount.class);
    public static final AccountType ACCOUNT_TYPE = AccountType.SAVING;
    public static final int MAX_MONTHLY_WITHDRAWALS = 5;
    private int monthlyWithdrawalsRemaining;

    public SavingsAccount(){}

    public SavingsAccount(BigDecimal balance) {
        super(balance);
        resetMonthlyWithdrawals();
    }

    public static AccountType getAccountType() {
        return ACCOUNT_TYPE;
    }

    public int monthlyWithdrawalsRemaining() {
        return monthlyWithdrawalsRemaining;
    }

    public void setMonthlyWithdrawalsLeft(int monthlyWithdrawalsRemaining) {
        this.monthlyWithdrawalsRemaining = monthlyWithdrawalsRemaining;
    }

    @Override
    public boolean withdrawal(BigDecimal amount) {
        if (super.getBalance().subtract(amount).signum() >= 0 && monthlyWithdrawalsRemaining > 0) {
            super.setBalance(super.getBalance().subtract(amount));
            monthlyWithdrawalsRemaining--;
            return true;
        } else if (super.getBalance().subtract(amount).signum() < 0) {
            throw new OverdraftException("Overdraft has occured");
        } else {
            LOGGER.info("Monthly withdrawal limit exceeded");
            return false;
        }
    }

    public void resetMonthlyWithdrawals(){
        monthlyWithdrawalsRemaining = MAX_MONTHLY_WITHDRAWALS;
    }
    @Override
    public String toString() {
        return "{\"Account Number\" : " + super.getAccountNumber() + ", \"Balance\" : " + super.getBalance() + ", \"Monthly Withdrawals Remaining\" : " + monthlyWithdrawalsRemaining + ", \"Account Type\" : " + ACCOUNT_TYPE + "}";
    }
}
