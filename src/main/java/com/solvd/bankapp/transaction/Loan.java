package com.solvd.bankapp.transaction;

import com.solvd.bankapp.account.Account;
import com.solvd.bankapp.exception.NegativeTransferAmountException;
import com.solvd.bankapp.exception.OverdraftException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Loan implements Payable {

    private static final Logger LOGGER = LogManager.getLogger(Loan.class);
    private Account accountFrom;
    private String loanType;
    private BigDecimal loanPrincipal;
    private BigDecimal interest;
    private int termYears;
    private BigDecimal totalAmount;
    private BigDecimal amountPayed;

    public Loan(Account accountFrom, String loanType, BigDecimal loanPrincipal, BigDecimal interest, int termYears) {
        this.accountFrom = accountFrom;
        this.loanType = loanType;
        this.loanPrincipal = loanPrincipal;
        this.interest = interest;
        this.termYears = termYears;
        this.totalAmount = totalAmount.add(loanPrincipal.multiply(interest).multiply(BigDecimal.valueOf(termYears)));
    }


    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
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

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(BigDecimal amountPayed) {
        this.amountPayed = amountPayed;
    }

    @Override
    public void pay(BigDecimal payment) throws NegativeTransferAmountException, OverdraftException {
        if (amountPayed.add(payment).compareTo(totalAmount) >= 0 && accountFrom.getBalance().subtract(payment).compareTo(BigDecimal.ZERO) >= 0) {
            accountFrom.deposit(payment);
            amountPayed = amountPayed.add(payment);
        } else if (amountPayed.add(payment).compareTo(totalAmount) < 0) {
            throw new NegativeTransferAmountException("Payment amount is negative");
        } else if (accountFrom.getBalance().subtract(payment).compareTo(BigDecimal.ZERO) < 0) {
            throw new OverdraftException("Payment is greater than remaining balance");
        }
    }

    @Override
    public void viewPaymentDetails() {
        LOGGER.info("Loan Type: " + loanType + "Loan Principal: " + loanPrincipal + ", Interest: " + interest + ", Term: " + termYears + " years, Total Amount: " + totalAmount + ", Amount Payed: " + amountPayed);
    }
}
