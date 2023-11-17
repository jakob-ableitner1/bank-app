package com.solvd.bankapp.exception;

public class OverdraftException extends RuntimeException{
    public OverdraftException(String message){
        super(message);
    }
}
