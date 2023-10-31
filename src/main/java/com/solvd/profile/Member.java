package com.solvd.profile;

import com.solvd.account.CheckingAccount;
import com.solvd.account.SavingsAccount;
import com.solvd.location.Address;

public class Member {
    private String name;
    private String username;
    private String password;
    private Address address;
    private CheckingAccount[] checkingAccounts;
    private SavingsAccount[] savingsAccounts;

    public Member(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CheckingAccount[] getCheckingAccounts() {
        return checkingAccounts;
    }

    public void setCheckingAccounts(CheckingAccount[] checkingAccounts) {
        this.checkingAccounts = checkingAccounts;
    }

    public SavingsAccount[] getSavingsAccounts() {
        return savingsAccounts;
    }

    public void setSavingsAccounts(SavingsAccount[] savingsAccounts) {
        this.savingsAccounts = savingsAccounts;
    }
}
