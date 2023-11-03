package com.solvd.transaction;

import com.solvd.account.Account;

import java.math.BigDecimal;

public class AccountMoneyTransfer extends Transaction{
    public AccountMoneyTransfer(Account fromAccount, Account toAccount, BigDecimal amount){
        super(fromAccount, toAccount, amount);
    }

    @Override
    public void performTransaction() {
        if (fromAccount.getMemberProfile().getId() == toAccount.getMemberProfile().getId()){
            if(fromAccount.withdrawal(amount)){
                toAccount.deposit(amount);
            }
        }
    }
}

