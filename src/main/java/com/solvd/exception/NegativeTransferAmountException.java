package com.solvd.exception;

public class NegativeTransferAmountException extends Exception{
    public NegativeTransferAmountException(String message){
        super(message);
    }
}
