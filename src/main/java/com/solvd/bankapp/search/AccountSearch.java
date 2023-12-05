package com.solvd.bankapp.search;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.SearchTypeException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountSearch implements ISearch<Account> {
    @Override
    public List<Account> search(Set<Account> accounts, String[] searchValues, String searchType) {
        if ("id".equals(searchType)) {
            String id = searchValues[0];

            List<Account> accountList = accounts.stream()
                    .filter(e -> id.equals(e.getAccountNumber().toString()))
                    .collect(Collectors.toList());
            return accountList;

        } else {
            throw new SearchTypeException("This search type is not valid");
        }
    }
}
