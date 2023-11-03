package com.solvd.account;

import com.solvd.profile.MemberProfile;

import java.math.BigDecimal;

public class CheckingAccount extends Account{

    private final static String ACCOUNT_TYPE = "Checking";
    public CheckingAccount(int accountNumber, MemberProfile memberProfile, BigDecimal balance) {
        super(accountNumber, memberProfile, balance);
    }

    public static String getAccountType(){
        return ACCOUNT_TYPE;
    }

    @Override
    public boolean withdrawal(BigDecimal amount) {
        if(balance.subtract(amount).signum() >= 0){
            balance = balance.subtract(amount);
            return true;
        } else {
            System.out.println("Not enough funds in account " + accountNumber);
            return false;
        }
    }

    @Override
    public String toString(){
        return "{\"Account Number\" : " + accountNumber + ", \"Member\" : " + memberProfile.getName() + ", \"Balance\" : " + balance + ", \"Account Type\" : " + ACCOUNT_TYPE + "}";
    }
}
