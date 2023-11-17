//package com.solvd.profile;
//
//import com.solvd.location.Address;
//
//import java.math.BigDecimal;
//
//public class EmployeeProfile extends Profile {
//    private String jobTitle;
//    private BigDecimal wage;
//
//    public EmployeeProfile(String name, String username, String password, Address address, String jobTitle, BigDecimal wage) {
//        super(name, username, password, address);
//        this.jobTitle = jobTitle;
//        this.wage = wage;
//    }
//
//    public String getJobTitle() {
//        return jobTitle;
//    }
//
//    public void setJobTitle(String jobTitle) {
//        this.jobTitle = jobTitle;
//    }
//
//    public BigDecimal getWage() {
//        return wage;
//    }
//
//    public void setWage(BigDecimal wage) {
//        this.wage = wage;
//    }
//
//    @Override
//    public void profileHelp() {
//        LOGGER.info("Contacting branch manager");
//    }
//
//    @Override
//    public String toString() {
//        return "{\"Name\" : " + super.getName() + ", \"Id\" : " + super.getId() + ", \"Password\" : " + super.getPassword() + ", \"Address\" : " + super.getAddress().toString() + ", \"Job Title\" : " + jobTitle + ", \"Wage\" : " + wage.toString() + "}";
//    }
//}
