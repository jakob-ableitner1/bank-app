package com.solvd.bankapp.profile;

import com.solvd.bankapp.exception.NegativeAgeException;
import com.solvd.bankapp.location.Address;

public abstract class Profile {
    private static int numberOfProfiles = 1;
    private String name;
    private int id;
    private String username;
    private String password;
    private int age;
    private Address address;

    public Profile(String name, String username, String password, int age, Address address) throws NegativeAgeException {
        this.name = name;
        this.id = numberOfProfiles;
        this.username = username;
        this.password = password;
        this.address = address;

        if (age >= 0) {
            this.age = age;
        } else {
            throw new NegativeAgeException("Age cannot be set to a negative value");
        }

        numberOfProfiles++;
    }

    public Profile(String name, String username, String password, int age) throws NegativeAgeException {
        this.name = name;
        this.id = numberOfProfiles;
        this.username = username;
        this.password = password;

        if (age >= 0) {
            this.age = age;
        } else {
            throw new NegativeAgeException("Age cannot be set to a negative value");
        }

        numberOfProfiles++;
    }

    public static int getNumberOfProfiles() {
        return numberOfProfiles;
    }

    public static void setNumberOfProfiles(int numberOfProfiles) {
        Profile.numberOfProfiles = numberOfProfiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
