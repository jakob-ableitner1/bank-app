package com.solvd.transaction;

import com.solvd.account.Account;

import java.math.BigDecimal;
import java.security.Principal;

public class Loan implements Payable{

    Account accountFrom;
    String loanType;
    BigDecimal loanPrincipal;
    BigDecimal interest;
    int termYears;
    BigDecimal totalAmount;
    BigDecimal amountPayed;

    public Loan(Account accountFrom, String loanType, BigDecimal loanPrincipal, BigDecimal interest, int termYears) {
        this.accountFrom = accountFrom;
        this.loanType = loanType;
        this.loanPrincipal = loanPrincipal;
        this.interest = interest;
        this.termYears = termYears;
        this.totalAmount = totalAmount.add(loanPrincipal.multiply(interest).multiply(BigDecimal.valueOf(termYears)));
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getLoanPrincipal() {
        return loanPrincipal;
    }

    public void setLoanPrincipal(BigDecimal loanPrincipal) {
        this.loanPrincipal = loanPrincipal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public int getTermYears() {
        return termYears;
    }

    public void setTermYears(int termYears) {
        this.termYears = termYears;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getAmountPayed() {
        return amountPayed;
    }

    @Override
    public void pay(BigDecimal payment) {
        if(amountPayed.add(payment).compareTo(totalAmount) >= 0 && accountFrom.getBalance().subtract(payment).compareTo(BigDecimal.ZERO) >= 0){
            accountFrom.deposit(payment);
            amountPayed = amountPayed.add(payment);
        } else{
            System.out.println("This amount is larger than remaining balance");
        }
    }

    @Override
    public void viewPaymentDetails() {
        System.out.println("Loan Type: " + loanType + "Loan Principal: " + loanPrincipal + ", Interest: " + interest + ", Term: " + termYears + " years, Total Amount: " + totalAmount + ", Amount Payed: " + amountPayed);
    }
}
