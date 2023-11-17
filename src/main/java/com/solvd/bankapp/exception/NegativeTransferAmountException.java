package com.solvd.bankapp.exception;

public class NegativeTransferAmountException extends RuntimeException{
    public NegativeTransferAmountException(String message){
        super(message);
    }
}
