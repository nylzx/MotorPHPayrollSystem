package com.motorph.model;

public class Deduction {

    private int deductionID;

    private int employeeID;

    private double salary_min;

    private double salary_max;

    private double sssDeduction;

    private double philhealthRate;

    private double pagDeduction;

    private double taxBase;

    private double taxRate;


    // Constructors

    public Deduction() {}

    public Deduction(int deductionID, int employeeID, double salary_min, double salary_max, double sssDeduction, double philhealthRate, double pagDeduction, double taxBase, double taxRate) {

        this.deductionID = deductionID;

        this.employeeID = employeeID;

        this.salary_min = salary_min;

        this.salary_max = salary_max;

        this.sssDeduction = sssDeduction;

        this.philhealthRate = philhealthRate;

        this.pagDeduction = pagDeduction;

        this.taxBase = taxBase;

        this.taxRate = taxRate;

    }


    // Getters and Setters

    public int getDeductionID() { return deductionID; }

    public void setDeductionID(int deductionID) { this.deductionID = deductionID; }

    public int getEmployeeID() { return employeeID; }

    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public double getSalary_min() { return salary_min; }

    public void setSalary_min(double salary_min) { this.salary_min = salary_min; }

    public double getSalary_max() { return salary_max; }

    public void setSalary_max(double salary_max) { this.salary_max = salary_max; }

    public double getSssDeduction() { return sssDeduction; }

    public void setSssDeduction(double sssDeduction) { this.sssDeduction = sssDeduction; }

    public double getPhilhealthRate() { return philhealthRate; }

    public void setPhilhealthRate(double philhealthRate) { this.philhealthRate = philhealthRate; }

    public double getPagDeduction() { return pagDeduction; }

    public void setPagDeduction(double pagDeduction) { this.pagDeduction = pagDeduction; }

    public double getTaxBase() { return taxBase; }

    public void setTaxBase(double taxBase) { this.taxBase = taxBase; }

    public double getTaxRate() { return taxRate; }

    public void setTaxRate(double taxRate) { this.taxRate = taxRate; }

}
