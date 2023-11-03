package com.solvd.account;

import com.solvd.location.Address;
import com.solvd.profile.MemberProfile;

import java.math.BigDecimal;

public class SavingsAccount extends Account{

    private final static String ACCOUNT_TYPE = "Savings";
    private int monthlyWithdrawalsRemaining;
    public SavingsAccount(int accountNumber, MemberProfile memberProfile, BigDecimal balance) {
        super(accountNumber, memberProfile, balance);
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
        if(balance.subtract(amount).signum() >= 0 && monthlyWithdrawalsRemaining > 0){
            balance = balance.subtract(amount);
            monthlyWithdrawalsRemaining--;
            return true;
        } else if (monthlyWithdrawalsRemaining > 0) {
            System.out.println("Not enough funds in account " + accountNumber);
            return false;
        } else {
            System.out.println("Monthly withdrawal limit exceeded");
            return false;
        }
    }

    @Override
    public String toString(){
        return "{\"Account Number\" : " + accountNumber + ", \"Member\" : " + memberProfile.getName() + ", \"Balance\" : " + balance + ", \"Monthly Withdrawals Remaining\" : " + monthlyWithdrawalsRemaining + ", \"Account Type\" : " + ACCOUNT_TYPE + "}";
    }
}
