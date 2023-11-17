package com.solvd.bankapp.exception;

public class NegativeAgeException extends RuntimeException{
    public NegativeAgeException(){
        super();
    }
    public NegativeAgeException(String message){
        super(message);
    }
}


