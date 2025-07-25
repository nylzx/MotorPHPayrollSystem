package com.motorph.model;

public class Position {

    private int positionID;

    private String positionName;


    // Constructors

    public Position() {}

    public Position(int positionID, String positionName) {

        this.positionID = positionID;

        this.positionName = positionName;

    }

    public Position(int aInt, String string, double aDouble) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    // Getters and Setters

    public int getPositionID() { return positionID; }

    public void setPositionID(int positionID) { this.positionID = positionID; }

    public String getPositionName() { return positionName; }

    public void setPositionName(String positionName) { this.positionName = positionName; }

}
