package com.solvd.transaction;

import com.solvd.exception.NegativeTransferAmountException;
import com.solvd.exception.OverdraftException;

import java.math.BigDecimal;

public interface Payable {
    void pay(BigDecimal payment) throws NegativeTransferAmountException, OverdraftException;
    void viewPaymentDetails();
}
