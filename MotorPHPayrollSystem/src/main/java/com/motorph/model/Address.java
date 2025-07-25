package com.motorph.model;

public class Address {

    private int addressID;

    private int employeeID;

    private String addressType;

    private String unitNumber;

    private String buildingName;

    private String street;

    private String barangay;

    private String city;

    private String province;

    private String zipcode;


    // Constructors

    public Address() {}

    public Address(int addressID, int employeeID, String addressType, String unitNumber, String buildingName, String street, String barangay, String city, String province, String zipcode) {

        this.addressID = addressID;

        this.employeeID = employeeID;

        this.addressType = addressType;

        this.unitNumber = unitNumber;

        this.buildingName = buildingName;

        this.street = street;

        this.barangay = barangay;

        this.city = city;

        this.province = province;

        this.zipcode = zipcode;

    }


    // Getters and Setters

    public int getAddressID() { return addressID; }

    public void setAddressID(int addressID) { this.addressID = addressID; }

    public int getEmployeeID() { return employeeID; }

    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getAddressType() { return addressType; }

    public void setAddressType(String addressType) { this.addressType = addressType; }

    public String getUnitNumber() { return unitNumber; }

    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public String getBuildingName() { return buildingName; }

    public void setBuildingName(String buildingName) { this.buildingName = buildingName; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getBarangay() { return barangay; }

    public void setBarangay(String barangay) { this.barangay = barangay; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

}
