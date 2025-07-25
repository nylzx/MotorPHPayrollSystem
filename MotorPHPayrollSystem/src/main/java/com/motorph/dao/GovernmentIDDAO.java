package com.motorph.dao;

import com.motorph.model.GovernmentID;
import com.motorph.util.DBConnection;
import java.sql.*;
import java.util.*;
public class GovernmentIDDAO {
    public List<GovernmentID> getAll() {
        List<GovernmentID> list = new ArrayList<>();
        String sql = "SELECT * FROM GovernmentID";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                GovernmentID governmentID = new GovernmentID();
                governmentID.setGovID(rs.getInt("govID"));
                governmentID.setEmployeeID(rs.getInt("employeeID"));
                governmentID.setSssNumber(rs.getString("sssNumber"));
                governmentID.setPhilhealthNumber(rs.getString("philhealthNumber"));
                governmentID.setTinNumber(rs.getString("tinNumber"));
                governmentID.setPagibigNumber(rs.getString("pagibigNumber"));
                list.add(governmentID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public GovernmentID getById(int id) {
        String sql = "SELECT * FROM GovernmentID WHERE govID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                GovernmentID governmentID = new GovernmentID();
                governmentID.setGovID(rs.getInt("govID"));
                governmentID.setEmployeeID(rs.getInt("employeeID"));
                governmentID.setSssNumber(rs.getString("sssNumber"));
                governmentID.setPhilhealthNumber(rs.getString("philhealthNumber"));
                governmentID.setTinNumber(rs.getString("tinNumber"));
                governmentID.setPagibigNumber(rs.getString("pagibigNumber"));
                return governmentID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean insert(GovernmentID governmentID) {
        String sql = "INSERT INTO GovernmentID (govID, employeeID, sssNumber, philhealthNumber, tinNumber, pagibigNumber) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, governmentID.getGovID());
            stmt.setObject(2, governmentID.getEmployeeID());
            stmt.setObject(3, governmentID.getSssNumber());
            stmt.setObject(4, governmentID.getPhilhealthNumber());
            stmt.setObject(5, governmentID.getTinNumber());
            stmt.setObject(6, governmentID.getPagibigNumber());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(GovernmentID governmentID) {
        String sql = "UPDATE GovernmentID SET employeeID=?, sssNumber=?, philhealthNumber=?, tinNumber=?, pagibigNumber=? WHERE govID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, governmentID.getEmployeeID());
            stmt.setObject(2, governmentID.getSssNumber());
            stmt.setObject(3, governmentID.getPhilhealthNumber());
            stmt.setObject(4, governmentID.getTinNumber());
            stmt.setObject(5, governmentID.getPagibigNumber());
            stmt.setObject(6, governmentID.getGovID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM GovernmentID WHERE govID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
