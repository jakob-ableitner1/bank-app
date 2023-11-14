package com.solvd.profile;

import com.solvd.App;
import com.solvd.account.Account;
import com.solvd.account.SavingsAccount;
import com.solvd.exception.NegativeAgeException;
import com.solvd.location.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemberProfile extends Profile {

    private static final Logger LOGGER = LogManager.getLogger(MemberProfile.class);
    private Set<Account> accounts;

    public MemberProfile(String name, String username, String password, int age, Address address, Set<Account> accounts) throws NegativeAgeException {
        super(name, username, password, age, address);
        this.accounts = accounts;
    }

    public MemberProfile(String name, String username, String password, int age, Address address) throws NegativeAgeException {
        super(name, username, password, age, address);
        accounts = new HashSet<>();
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void profileHelp() {
        LOGGER.info("Contacting bank employee");
    }

    @Override
    public String toString() {
        return "{\"Name\" : " + super.getName() + ", \"Id\" : " + super.getId() + ", \"Password\" : " + super.getPassword() + ", \"Address\" : " + super.getAddress().toString() + ", \"Accounts\" : " + accounts.toString() + "}";
    }
}
