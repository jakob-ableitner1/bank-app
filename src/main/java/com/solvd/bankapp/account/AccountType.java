package com.solvd.bankapp.account;

public enum AccountType {

    CHECKING("checking", 1),
    SAVING("saving", 2);

    private String displayName;
    private int number;

    AccountType(String displayName, int number){
        this.displayName = displayName;
        this.number = number;
    }
}
