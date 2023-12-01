package com.solvd.bankapp.profile;

import com.solvd.bankapp.exception.NegativeAgeException;
import com.solvd.bankapp.location.Address;

import java.util.UUID;

public abstract class Profile {
    public final UUID id;
    private String name;
    private String username;
    private String password;
    private int age;
    private Address address;

    {
        id = UUID.randomUUID();
    }

    public Profile() {
    }

    public Profile(String name, String username, String password) throws NegativeAgeException {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws NegativeAgeException {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new NegativeAgeException("Age cannot be set to a negative value");
        }
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public abstract void profileHelp();
}
