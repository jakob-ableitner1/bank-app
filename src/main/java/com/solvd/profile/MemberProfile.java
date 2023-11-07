package com.solvd.profile;

import com.solvd.account.Account;
import com.solvd.account.SavingsAccount;
import com.solvd.location.Address;

import java.util.Arrays;

public class MemberProfile extends Profile {

    private int maxNumberOfAccounts = 5;

    private Account[] accounts = new Account[maxNumberOfAccounts];

    public MemberProfile(String name, String id, String password) {
        super(name, id, password);
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
      return "{\"Name\" : " + super.getName() + ", \"Id\" : " + super.getId() + ", \"Password\" : " + super.getPassword() + ", \"Address\" : " + super.getAddress().toString() + ", \"Accounts\" : " + Arrays.toString(accounts)+ "}";
     }
}
