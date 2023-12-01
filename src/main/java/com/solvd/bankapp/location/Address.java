package com.solvd.bankapp.location;

public class Address {
    private String streetLine;
    private State state;
    private String city;
    private int zipCode;
    private String country;

    public Address(){}

    public Address(String streetLine, State state, String city, int zipCode, String country) {
        this.streetLine = streetLine;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreetLine() {
        return streetLine;
    }

    public void setStreetLine(String streetLine) {
        this.streetLine = streetLine;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return "{\"Street Line\" : " + streetLine + ", \"State\" : " + state + ", \"City\" : " + city + ", \"Zip Code\" : " + zipCode + ", \"Country\" : " + country + "}";
    }
}
