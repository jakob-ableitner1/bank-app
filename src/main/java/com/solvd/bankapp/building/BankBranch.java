package com.solvd.bankapp.building;

import com.solvd.bankapp.exception.PhoneNumberException;
import com.solvd.bankapp.location.Address;

public class BankBranch {
    private Address address;
    private String phoneNumber;
    private int branchNumber;

    public BankBranch(Address address, String phoneNumber, int branchNumber) throws PhoneNumberException {

        if (phoneNumber.length() != 10) {
            throw new PhoneNumberException("Phone number is not the correct length");
        }

        this.address = address;
        this.phoneNumber = phoneNumber;
        this.branchNumber = branchNumber;
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

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    @Override
    public String toString() {
        return "{\"Address\" : " + address + ", \"Phone Number\" : " + phoneNumber + ", \"Branch Number\" : " + phoneNumber + "}";
    }
}
