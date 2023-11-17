package com.solvd.bankapp.search;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.SearchTypeException;

import java.util.Set;

public class AccountSearch implements ISearch<Account> {
    @Override
    public Account[] search(Set<Account> accounts, String[] searchValues, String searchType) {
        if ("id".equals(searchType)) {
            int id = Integer.parseInt(searchValues[0]);

            for (Account account : accounts) {
                if (id == account.getAccountNumber()) {
                    return new Account[]{account};
                }
            }
        } else {
            throw new SearchTypeException("This search type is not valid");
        }
        return null;
    }
}
