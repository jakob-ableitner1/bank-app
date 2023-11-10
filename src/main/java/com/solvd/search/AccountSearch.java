package com.solvd.search;

import com.solvd.account.Account;
import com.solvd.exception.SearchTypeException;

public class AccountSearch implements ISearch<Account> {
    @Override
    public Account[] search(Account[] accounts, String[] searchValues, String searchType) throws SearchTypeException {
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
