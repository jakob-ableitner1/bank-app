package com.solvd.profile;

import com.solvd.App;
import com.solvd.account.Account;
import com.solvd.account.SavingsAccount;
import com.solvd.location.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MemberProfile extends Profile {

    private static final Logger LOGGER = LogManager.getLogger(MemberProfile.class);
    private int maxNumberOfAccounts = 5;

    private Account[] accounts = new Account[maxNumberOfAccounts];

    public MemberProfile(String name, String username, String password, Address address, int age, Account[] accounts) {
        super(name, username, password, age, address);
        this.accounts = accounts;
    }

    public MemberProfile(String name, String username, String password, int age, Address address) {
        super(name, username, password, age, address);
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public void profileHelp() {
        LOGGER.info("Contacting bank employee");
    }

    @Override
    public String toString() {
        return "{\"Name\" : " + super.getName() + ", \"Id\" : " + super.getId() + ", \"Password\" : " + super.getPassword() + ", \"Address\" : " + super.getAddress().toString() + ", \"Accounts\" : " + Arrays.toString(accounts) + "}";
    }
}
