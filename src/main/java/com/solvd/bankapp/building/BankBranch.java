package com.solvd.bankapp.building;

import com.solvd.bankapp.exception.PhoneNumberException;
import com.solvd.bankapp.location.Address;

public class BankBranch {
    private Address address;
    private String phoneNumber;

    public BankBranch(){}

    public BankBranch(Address address, String phoneNumber) throws PhoneNumberException {

        if (phoneNumber.length() != 10) {
            throw new PhoneNumberException("Phone number is not the correct length");
        }

        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "{\"Address\" : " + address + ", \"Phone Number\" : " + phoneNumber + ", \"Branch Number\" : " + phoneNumber + "}";
    }
}
