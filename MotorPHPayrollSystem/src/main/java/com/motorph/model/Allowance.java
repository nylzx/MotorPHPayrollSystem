package com.motorph.model;

public class Allowance {

    private int allowanceID;

    private int employeeID;

    private double riceSubsidy;

    private double phoneAllowance;

    private double clothingAllowance;

    private java.sql.Date effectiveDate;


    // Constructors

    public Allowance() {}

    public Allowance(int allowanceID, int employeeID, double riceSubsidy, double phoneAllowance, double clothingAllowance, java.sql.Date effectiveDate) {

        this.allowanceID = allowanceID;

        this.employeeID = employeeID;

        this.riceSubsidy = riceSubsidy;

        this.phoneAllowance = phoneAllowance;

        this.clothingAllowance = clothingAllowance;

        this.effectiveDate = effectiveDate;

    }


    // Getters and Setters

    public int getAllowanceID() { return allowanceID; }

    public void setAllowanceID(int allowanceID) { this.allowanceID = allowanceID; }

    public int getEmployeeID() { return employeeID; }

    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public double getRiceSubsidy() { return riceSubsidy; }

    public void setRiceSubsidy(double riceSubsidy) { this.riceSubsidy = riceSubsidy; }

    public double getPhoneAllowance() { return phoneAllowance; }

    public void setPhoneAllowance(double phoneAllowance) { this.phoneAllowance = phoneAllowance; }

    public double getClothingAllowance() { return clothingAllowance; }

    public void setClothingAllowance(double clothingAllowance) { this.clothingAllowance = clothingAllowance; }

    public java.sql.Date getEffectiveDate() { return effectiveDate; }

    public void setEffectiveDate(java.sql.Date effectiveDate) { this.effectiveDate = effectiveDate; }

}
