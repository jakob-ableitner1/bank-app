package com.solvd.bankapp.transaction;

public enum LoanType {

    CAR("Car", 1),
    HOUSE("House", 2),
    SCHOOL("School", 3),
    PERSONAL("Personal", 4);

    private String displayName;
    private int number;

    LoanType(String displayName, int number){
        this.displayName = displayName;
        this.number = number;
    }


}
