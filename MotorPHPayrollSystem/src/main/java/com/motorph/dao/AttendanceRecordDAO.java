package com.motorph.dao;

import com.motorph.model.AttendanceRecord;
import com.motorph.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRecordDAO {

    public AttendanceRecord getById(int id) {
        String sql = "SELECT * FROM AttendanceRecord WHERE attendanceID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AttendanceRecord record = new AttendanceRecord();
                record.setAttendanceID(rs.getInt("attendanceID"));
                record.setEmployeeID(rs.getInt("employeeID"));
                record.setDate(rs.getDate("date"));
                record.setLogin(rs.getTime("login"));
                record.setLogout(rs.getTime("logout"));
                return record;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AttendanceRecord> getAll() {
        List<AttendanceRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM AttendanceRecord";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                AttendanceRecord record = new AttendanceRecord();
                record.setAttendanceID(rs.getInt("attendanceID"));
                record.setEmployeeID(rs.getInt("employeeID"));
                record.setDate(rs.getDate("date"));
                record.setLogin(rs.getTime("login"));
                record.setLogout(rs.getTime("logout"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public boolean insert(AttendanceRecord record) {
        String sql = "INSERT INTO AttendanceRecord (employeeID, date, login, logout) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, record.getEmployeeID());
            stmt.setDate(2, record.getDate());
            stmt.setTime(3, record.getLogin());
            stmt.setTime(4, record.getLogout());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(AttendanceRecord record) {
        String sql = "UPDATE AttendanceRecord SET employeeID=?, date=?, login=?, logout=? WHERE attendanceID=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, record.getEmployeeID());
            stmt.setDate(2, record.getDate());
            stmt.setTime(3, record.getLogin());
            stmt.setTime(4, record.getLogout());
            stmt.setInt(5, record.getAttendanceID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM AttendanceRecord WHERE attendanceID=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
