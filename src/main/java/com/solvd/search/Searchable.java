package com.solvd.search;

import com.solvd.account.Account;
import com.solvd.profile.Profile;

public interface Searchable {
    Searchable search(String value);
    void viewAll();
}
