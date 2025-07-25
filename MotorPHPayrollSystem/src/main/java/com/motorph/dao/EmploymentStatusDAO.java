package com.motorph.dao;

import com.motorph.model.EmploymentStatus;
import com.motorph.util.DBConnection;
import java.sql.*;
import java.util.*;
public class EmploymentStatusDAO {
    public List<EmploymentStatus> getAll() {
        List<EmploymentStatus> list = new ArrayList<>();
        String sql = "SELECT * FROM EmploymentStatus";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EmploymentStatus employmentStatus = new EmploymentStatus();
                employmentStatus.setStatusID(rs.getInt("statusID"));
                employmentStatus.setStatusName(rs.getString("statusName"));
                list.add(employmentStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public EmploymentStatus getById(int id) {
        String sql = "SELECT * FROM EmploymentStatus WHERE statusID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                EmploymentStatus employmentStatus = new EmploymentStatus();
                employmentStatus.setStatusID(rs.getInt("statusID"));
                employmentStatus.setStatusName(rs.getString("statusName"));
                return employmentStatus;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean insert(EmploymentStatus employmentStatus) {
        String sql = "INSERT INTO EmploymentStatus (statusID, statusName) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, employmentStatus.getStatusID());
            stmt.setObject(2, employmentStatus.getStatusName());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(EmploymentStatus employmentStatus) {
        String sql = "UPDATE EmploymentStatus SET statusName=? WHERE statusID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, employmentStatus.getStatusName());
            stmt.setObject(2, employmentStatus.getStatusID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM EmploymentStatus WHERE statusID = ?";
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
