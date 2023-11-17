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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberProfile that = (MemberProfile) o;
        return Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }
}
