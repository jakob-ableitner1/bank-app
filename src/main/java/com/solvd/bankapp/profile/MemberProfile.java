package com.solvd.bankapp.profile;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.NegativeAgeException;
import com.solvd.bankapp.location.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MemberProfile extends Profile {

    private static final Logger LOGGER = LogManager.getLogger(MemberProfile.class);
    private Set<Account> accounts;

    public MemberProfile(){}

    public MemberProfile(String name, String username, String password){
        super(name, username, password);
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
        return "{\"Name\" : " + super.getName() + ", \"Id\" : " + super.getId() + ", \"Password\" : " + super.getPassword() + ", \"Address\" : " + super.getAddress() + ", \"Accounts\" : " + accounts + "}";
    }
}
