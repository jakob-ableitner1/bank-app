package com.solvd.transaction;

import com.solvd.account.Account;

import java.math.BigDecimal;

public class AccountMoneyTransfer extends Transaction{
    public AccountMoneyTransfer(Account fromAccount, Account toAccount, BigDecimal amount){
        super(fromAccount, toAccount, amount);
    }

    @Override
    public void performTransaction() {

        if(super.getFromAccount().withdrawal(super.getAmount())){
            super.getToAccount().deposit(super.getAmount());
            System.out.println("Money transfer completed");
        }

    }
}

