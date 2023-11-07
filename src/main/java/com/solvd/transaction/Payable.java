package com.solvd.transaction;

import java.math.BigDecimal;

public interface Payable {
    void pay(BigDecimal payment);
    void viewPaymentDetails();
}
