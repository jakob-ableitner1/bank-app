package com.solvd.account;

import com.solvd.location.Address;
import com.solvd.profile.MemberProfile;

import java.math.BigDecimal;

public class SavingsAccount extends Account{

    private final static String ACCOUNT_TYPE = "Savings";
    private int monthlyWithdrawalsRemaining;
    public SavingsAccount(int accountNumber, BigDecimal balance) {
        super(accountNumber, balance);
        this.monthlyWithdrawalsRemaining = 5;
    }

    public static String getAccountType(){
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
        if(super.getBalance().subtract(amount).signum() >= 0 && monthlyWithdrawalsRemaining > 0){
            super.setBalance(super.getBalance().subtract(amount));
            monthlyWithdrawalsRemaining--;
            return true;
        } else if (monthlyWithdrawalsRemaining > 0) {
            System.out.println("Not enough funds in account " + super.getAccountNumber());
            return false;
        } else {
            System.out.println("Monthly withdrawal limit exceeded");
            return false;
        }
    }

    @Override
    public String toString(){
        return "{\"Account Number\" : " + super.getAccountNumber() + ", \"Balance\" : " + super.getBalance() + ", \"Monthly Withdrawals Remaining\" : " + monthlyWithdrawalsRemaining + ", \"Account Type\" : " + ACCOUNT_TYPE + "}";
    }
}
