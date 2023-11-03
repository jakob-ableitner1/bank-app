package com.solvd.transaction;

import com.solvd.account.Account;

import java.math.BigDecimal;

public class Check extends Transaction{
    public Check(Account fromAccount, Account toAccount, BigDecimal amount){
        super(fromAccount, toAccount, amount);
    }

    @Override
    public void performTransaction() {
        if(fromAccount.withdrawal(amount)){
            toAccount.deposit(amount);
        }
    }
}
