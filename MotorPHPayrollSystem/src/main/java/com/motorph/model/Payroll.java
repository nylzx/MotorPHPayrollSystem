package com.motorph.model;

public class Payroll {

    private int payrollID;

    private int employeeID;

    private int salaryID;

    private int deductionID;

    private int allowanceID;

    private int payPeriodID;

    private double workHours;

    private double overtimeHours;

    private double grossPay;

    private double netPay;


    // Constructors

    public Payroll() {}

    public Payroll(int payrollID, int employeeID, int salaryID, int deductionID, int allowanceID, int payPeriodID, double workHours, double overtimeHours, double grossPay, double netPay) {

        this.payrollID = payrollID;

        this.employeeID = employeeID;

        this.salaryID = salaryID;

        this.deductionID = deductionID;

        this.allowanceID = allowanceID;

        this.payPeriodID = payPeriodID;

        this.workHours = workHours;

        this.overtimeHours = overtimeHours;

        this.grossPay = grossPay;

        this.netPay = netPay;

    }


    // Getters and Setters

    public int getPayrollID() { return payrollID; }

    public void setPayrollID(int payrollID) { this.payrollID = payrollID; }

    public int getEmployeeID() { return employeeID; }

    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public int getSalaryID() { return salaryID; }

    public void setSalaryID(int salaryID) { this.salaryID = salaryID; }

    public int getDeductionID() { return deductionID; }

    public void setDeductionID(int deductionID) { this.deductionID = deductionID; }

    public int getAllowanceID() { return allowanceID; }

    public void setAllowanceID(int allowanceID) { this.allowanceID = allowanceID; }

    public int getPayPeriodID() { return payPeriodID; }

    public void setPayPeriodID(int payPeriodID) { this.payPeriodID = payPeriodID; }

    public double getWorkHours() { return workHours; }

    public void setWorkHours(double workHours) { this.workHours = workHours; }

    public double getOvertimeHours() { return overtimeHours; }

    public void setOvertimeHours(double overtimeHours) { this.overtimeHours = overtimeHours; }

    public double getGrossPay() { return grossPay; }

    public void setGrossPay(double grossPay) { this.grossPay = grossPay; }

    public double getNetPay() { return netPay; }

    public void setNetPay(double netPay) { this.netPay = netPay; }

}
