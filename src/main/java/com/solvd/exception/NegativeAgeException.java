package com.solvd.exception;

public class NegativeAgeException extends Exception{
    public NegativeAgeException(){
        super();
    }
    public NegativeAgeException(String message){
        super(message);
    }
}
