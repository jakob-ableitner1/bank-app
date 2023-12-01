package com.solvd.bankapp.transaction;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.NegativeTransferAmountException;
import com.solvd.bankapp.exception.OverdraftException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class BillPay implements Payable {

    private static final Logger LOGGER = LogManager.getLogger(BillPay.class);
    private Account fromAccount;
    private String toAccountNumber;
    private BigDecimal amount;
    private String frequency;
    private String details;

    public BillPay(){}

    public BillPay(Account fromAccount, String toAccountNumber, BigDecimal amount) {
        this.fromAccount = fromAccount;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
    }

    public Account getFromAccountNumber() {
        return fromAccount;
    }

    public void setFromAccountNumber(Account fromAccountNumber) {
        this.fromAccount = fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public void pay(BigDecimal payment) throws NegativeTransferAmountException, OverdraftException {

        if (payment.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeTransferAmountException("Payment amount cannot be negative");
        }

//        if(amountPayed.add(payment).compareTo(totalAmount) >= 0 && accountFrom.getBalance().subtract(payment).compareTo(BigDecimal.ZERO) >= 0){
//            accountFrom.deposit(payment);
//            amountPayed = amountPayed.add(payment);
//        } else{
//            LOGGER.info("This amount is larger than remaining balance");
//        }

        LOGGER.info("Amount Payed");
    }

    public void viewPaymentDetails() {
//        LOGGER.info("Loan Principal: " + loanPrincipal + ", Interest: " + interest + ", Term: " + termYears + " years, Total Amount: " + totalAmount + ", Amount Payed: " + amountPayed);
        LOGGER.info("Bill Pay details");
    }
}
