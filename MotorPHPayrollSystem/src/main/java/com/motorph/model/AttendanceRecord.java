package com.motorph.model;

import java.sql.Date;
import java.sql.Time;

public class AttendanceRecord {
    private int attendanceID;
    private int employeeID;
    private Date date;
    private Time login;
    private Time logout;

    // Getters and Setters
    public int getAttendanceID() { return attendanceID; }
    public void setAttendanceID(int attendanceID) { this.attendanceID = attendanceID; }

    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Time getLogin() { return login; }
    public void setLogin(Time login) { this.login = login; }

    public Time getLogout() { return logout; }
    public void setLogout(Time logout) { this.logout = logout; }
}
