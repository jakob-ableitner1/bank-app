package com.solvd.bankapp.transaction;

import com.solvd.bankapp.exception.NegativeTransferAmountException;
import com.solvd.bankapp.exception.OverdraftException;

import java.math.BigDecimal;

public interface Payable {
    void pay(BigDecimal payment) throws NegativeTransferAmountException, OverdraftException;
    void viewPaymentDetails();
}
