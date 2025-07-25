package com.motorph.model;

public class Salary {

    private int salaryID;

    private int employeeID;

    private double baseSalary;

    private double grossSemiMonthlyRate;

    private double hourlyRate;


    // Constructors

    public Salary() {}

    public Salary(int salaryID, int employeeID, double baseSalary, double grossSemiMonthlyRate, double hourlyRate) {

        this.salaryID = salaryID;

        this.employeeID = employeeID;

        this.baseSalary = baseSalary;

        this.grossSemiMonthlyRate = grossSemiMonthlyRate;

        this.hourlyRate = hourlyRate;

    }


    // Getters and Setters

    public int getSalaryID() { return salaryID; }

    public void setSalaryID(int salaryID) { this.salaryID = salaryID; }

    public int getEmployeeID() { return employeeID; }

    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public double getBaseSalary() { return baseSalary; }

    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public double getGrossSemiMonthlyRate() { return grossSemiMonthlyRate; }

    public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) { this.grossSemiMonthlyRate = grossSemiMonthlyRate; }

    public double getHourlyRate() { return hourlyRate; }

    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

}
