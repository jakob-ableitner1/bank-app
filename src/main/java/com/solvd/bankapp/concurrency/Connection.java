package com.solvd.bankapp.concurrency;

public class Connection {
    private String name;

    public Connection(){};

    public void setName(String name){
        this.name = name;
    }

    public String getName() throws InterruptedException {
        return name;
    }
}
