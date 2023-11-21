package com.solvd.bankapp.profile;

import com.solvd.bankapp.location.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class EmployeeProfile extends Profile {

    private static final Logger LOGGER = LogManager.getLogger(MemberProfile.class);

    private String jobTitle;
    private BigDecimal wage;

    public EmployeeProfile(String name, String username, String password, int age, Address address, String jobTitle, BigDecimal wage) {
        super(name, username, password, age, address);
        this.jobTitle = jobTitle;
        this.wage = wage;
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
    public void profileHelp() {
        LOGGER.info("Contacting branch manager");
    }

    @Override
    public String toString() {
        return "{\"Name\" : " + super.getName() + ", \"Id\" : " + super.getId() + ", \"Password\" : " + super.getPassword() + ", \"Address\" : " + super.getAddress().toString() + ", \"Job Title\" : " + jobTitle + ", \"Wage\" : " + wage.toString() + "}";
    }
}
