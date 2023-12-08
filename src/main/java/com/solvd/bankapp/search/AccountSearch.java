package com.solvd.bankapp.search;

import com.solvd.bankapp.account.Account;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountSearch implements ISearch<Account> {
    @Override
    public Account search(Set<Account> accounts, String searchValue, String searchType) {
        if ("id".equals(searchType)) {
            String id = searchValue;

            Account account = accounts.stream()
                    .filter(a -> id.equals(a.getAccountNumber().toString()))
                    .findFirst().orElseThrow(() -> new RuntimeException("Account not found"));
            return account;
        }
        return null;
    }
}
