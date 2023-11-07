package com.solvd.account;

import com.solvd.profile.MemberProfile;

import java.math.BigDecimal;

public class CheckingAccount extends Account{

    private final static String ACCOUNT_TYPE = "Checking";
    public CheckingAccount(int accountNumber, BigDecimal balance) {
        super(accountNumber, balance);
    }

    public static String getAccountType(){
        return ACCOUNT_TYPE;
    }

    @Override
    public boolean withdrawal(BigDecimal amount) {
        if(super.getBalance().subtract(amount).signum() >= 0){
            super.setBalance(super.getBalance().subtract(amount));
            return true;
        } else {
            System.out.println("Not enough funds in account " + super.getAccountNumber());
            return false;
        }
    }

    @Override
    public String toString(){
        return "{\"Account Number\" : " + super.getAccountNumber()  + ", \"Balance\" : " + super.getBalance() + ", \"Account Type\" : " + ACCOUNT_TYPE + "}";
    }
}
