package com.motorph.model;

import java.sql.Date;

public class PayPeriod {

    private int payPeriodID;

    private java.sql.Date payPeriod_start;

    private java.sql.Date payPeriod_end;


    // Constructors

    public PayPeriod() {}

    public PayPeriod(int payPeriodID, java.sql.Date payPeriod_start, java.sql.Date payPeriod_end) {

        this.payPeriodID = payPeriodID;

        this.payPeriod_start = payPeriod_start;

        this.payPeriod_end = payPeriod_end;

    }


    // Getters and Setters

    public int getPayPeriodID() { return payPeriodID; }

    public void setPayPeriodID(int payPeriodID) { this.payPeriodID = payPeriodID; }

    public java.sql.Date getPayPeriod_start() { return payPeriod_start; }

    public void setPayPeriod_start(java.sql.Date payPeriod_start) { this.payPeriod_start = payPeriod_start; }

    public java.sql.Date getPayPeriod_end() { return payPeriod_end; }

    public void setPayPeriod_end(java.sql.Date payPeriod_end) { this.payPeriod_end = payPeriod_end; }

    public Date getStartDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getEndDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
