package com.solvd.profile;

import java.math.BigDecimal;

public class EmployeeProfile extends Profile {
    private String jobTitle;
    private BigDecimal wage;

    public EmployeeProfile(String name, String id, String password) {
        super(name, id, password);
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    @Override
    public void profileHelp(){
        System.out.println("Contacting branch manager");
    }

    @Override
    public String toString(){
        return "{\"Name\" : " + super.getName() + ", \"Id\" : " + super.getId() + ", \"Password\" : " + super.getPassword() + ", \"Address\" : " + super.getAddress().toString() + ", \"Job Title\" : " + jobTitle + ", \"Wage\" : " + wage.toString() + "}";
    }
}
