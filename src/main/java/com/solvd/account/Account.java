package com.solvd.account;

import com.solvd.profile.MemberProfile;

import java.math.BigDecimal;

public abstract class Account {
    protected int accountNumber;
    protected MemberProfile memberProfile;
    protected BigDecimal balance;


    public Account(int accountNumber, MemberProfile memberProfile, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.memberProfile = memberProfile;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public MemberProfile getMemberProfile() {
        return memberProfile;
    }

    public void setMemberProfile(MemberProfile memberProfile) {
        this.memberProfile = memberProfile;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount){
        balance = balance.add(amount);
    }

    public abstract boolean withdrawal(BigDecimal amount);
    public abstract String toString();
}
