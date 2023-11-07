package com.solvd.transaction;

import com.solvd.account.Account;
import jdk.swing.interop.SwingInterOpUtils;

import javax.xml.transform.Source;
import java.math.BigDecimal;

public class BillPay implements Payable{

    Account fromAccount;
    String toAccountNumber;
    BigDecimal amount;
    String frequency;
    String details;

    public BillPay(Account fromAccount, String toAccountNumber, BigDecimal amount, String frequency, String details) {
        this.fromAccount = fromAccount;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.frequency = frequency;
        this.details = details;
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
    public void pay(BigDecimal payment) {
//        if(amountPayed.add(payment).compareTo(totalAmount) >= 0 && accountFrom.getBalance().subtract(payment).compareTo(BigDecimal.ZERO) >= 0){
//            accountFrom.deposit(payment);
//            amountPayed = amountPayed.add(payment);
//        } else{
//            System.out.println("This amount is larger than remaining balance");
//        }

        System.out.println("Amount Payed");
    }

    public void viewPaymentDetails() {
//        System.out.println("Loan Principal: " + loanPrincipal + ", Interest: " + interest + ", Term: " + termYears + " years, Total Amount: " + totalAmount + ", Amount Payed: " + amountPayed);
        System.out.println("Bill Pay details");
    }
}
