package com.solvd.bankapp.account;

import com.solvd.bankapp.exception.OverdraftException;
import com.solvd.bankapp.transaction.Check;

import java.math.BigDecimal;

public class CheckingAccount extends Account {

    public final static AccountType ACCOUNT_TYPE = AccountType.CHECKING;

    public CheckingAccount(){}

    public CheckingAccount(BigDecimal balance) {
        super(balance);
    }

    public static AccountType getAccountType() {
        return ACCOUNT_TYPE;
    }

    @Override
    public boolean withdrawal(BigDecimal amount) throws OverdraftException {
        if (super.getBalance().subtract(amount).signum() >= 0) {
            super.setBalance(super.getBalance().subtract(amount));
            return true;
        } else {
            throw new OverdraftException("This amount is more than the current balance");
        }
    }

    @Override
    public String toString() {
        return "{\"Account Number\" : " + super.getAccountNumber() + ", \"Balance\" : " + super.getBalance() + ", \"Account Type\" : " + ACCOUNT_TYPE + "}";
    }
}
