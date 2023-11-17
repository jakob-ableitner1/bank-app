package com.solvd.bankapp.transaction;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.OverdraftException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Check extends Transaction {

    private static final Logger LOGGER = LogManager.getLogger(Check.class);

    public Check(Account fromAccount, Account toAccount, BigDecimal amount) {
        super(fromAccount, toAccount, amount);
    }

    @Override
    public void performTransaction() {

        try {
            if (super.getFromAccount().withdrawal(super.getAmount())) {
                super.getToAccount().deposit(super.getAmount());
                LOGGER.info("Check has been cashed");
            }
        } catch (OverdraftException e) {
            LOGGER.info("Check was bounced due to non sufficient funds");
        }
    }
}
