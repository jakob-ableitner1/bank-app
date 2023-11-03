package com.solvd.profile;

import com.solvd.account.Account;
import com.solvd.account.SavingsAccount;
import com.solvd.location.Address;

import java.util.Arrays;

public class MemberProfile extends Profile {

    private int maxNumberOfAccounts = 5;
    private Address address = new Address();

    private Account[] accounts = new Account[maxNumberOfAccounts];

    public MemberProfile(String name, String id, String password) {
        super(name, id, password);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public void profileHelp(){
        System.out.println("Contacting bank employee");
    }

    @Override
    public String toString(){
      return "{\"Name\" : " + name + ", \"Id\" : " + id + ", \"Password\" : " + password + ", \"Address\" : " + address.toString() + ", \"Accounts\" : " + Arrays.toString(accounts)+ "}";
    }
}
