package com.motorph.model;

public class EmploymentStatus {

    private int statusID;

    private String statusName;


    // Constructors

    public EmploymentStatus() {}

    public EmploymentStatus(int statusID, String statusName) {

        this.statusID = statusID;

        this.statusName = statusName;

    }


    // Getters and Setters

    public int getStatusID() { return statusID; }

    public void setStatusID(int statusID) { this.statusID = statusID; }

    public String getStatusName() { return statusName; }

    public void setStatusName(String statusName) { this.statusName = statusName; }

}
