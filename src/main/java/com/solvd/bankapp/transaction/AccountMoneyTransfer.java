package com.solvd.bankapp.transaction;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.OverdraftException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class AccountMoneyTransfer extends Transaction {

    private static final Logger LOGGER = LogManager.getLogger(AccountMoneyTransfer.class);

    public AccountMoneyTransfer(){
        super();
    }

    public AccountMoneyTransfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        super(fromAccount, toAccount, amount);
    }

    @Override
    public void performTransaction() {

        try {
            if (super.getFromAccount().withdrawal(super.getAmount())) {
                super.getToAccount().deposit(super.getAmount());
                LOGGER.info("Money transfer completed");
            }
        } catch (OverdraftException e) {
            LOGGER.info(e.getMessage());
        }
    }
}

