package com.motorph.model;

public class GovernmentID {

    private int govID;

    private int employeeID;

    private String sssNumber;

    private String philhealthNumber;

    private String tinNumber;

    private String pagibigNumber;


    // Constructors

    public GovernmentID() {}

    public GovernmentID(int govID, int employeeID, String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber) {

        this.govID = govID;

        this.employeeID = employeeID;

        this.sssNumber = sssNumber;

        this.philhealthNumber = philhealthNumber;

        this.tinNumber = tinNumber;

        this.pagibigNumber = pagibigNumber;

    }


    // Getters and Setters

    public int getGovID() { return govID; }

    public void setGovID(int govID) { this.govID = govID; }

    public int getEmployeeID() { return employeeID; }

    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getSssNumber() { return sssNumber; }

    public void setSssNumber(String sssNumber) { this.sssNumber = sssNumber; }

    public String getPhilhealthNumber() { return philhealthNumber; }

    public void setPhilhealthNumber(String philhealthNumber) { this.philhealthNumber = philhealthNumber; }

    public String getTinNumber() { return tinNumber; }

    public void setTinNumber(String tinNumber) { this.tinNumber = tinNumber; }

    public String getPagibigNumber() { return pagibigNumber; }

    public void setPagibigNumber(String pagibigNumber) { this.pagibigNumber = pagibigNumber; }

}
