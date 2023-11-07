package com.solvd.profile;

import com.solvd.location.Address;
import com.solvd.search.Searchable;

public abstract class Profile implements Searchable {
    private static Profile[] profiles = new Profile[20];
    private String name;
    private String id;
    private String password;
    private Address address;

    public Profile(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
        addToProfilesArray();
    }

    public static Profile[] getProfiles() {
        return profiles;
    }

    public static void setProfiles(Profile[] profiles) {
        Profile.profiles = profiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addToProfilesArray(){
        for (Profile p : profiles){
            if (p == null){
                p = this;
                break;
            }
        }
    }

    public Searchable search(String value){
        for (Profile p : profiles){
            if (value.equals(p.id)){
                return p;
            }
        }
        return null;
    }

    public void viewAll(){

    }

    public abstract void profileHelp();
}
