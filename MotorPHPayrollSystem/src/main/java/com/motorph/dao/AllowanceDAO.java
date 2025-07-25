package com.motorph.dao;

import com.motorph.model.Allowance;
import com.motorph.util.DBConnection;

import java.sql.*;
import java.util.*;

public class AllowanceDAO {

    public List<Allowance> getAll() {
        List<Allowance> list = new ArrayList<>();
        String sql = "SELECT * FROM allowance";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Allowance allowance = new Allowance();
                allowance.setAllowanceID(rs.getInt("allowanceID"));
                allowance.setEmployeeID(rs.getInt("employeeID"));
                allowance.setRiceSubsidy(rs.getDouble("riceSubsidy"));
                allowance.setPhoneAllowance(rs.getDouble("phoneAllowance"));
                allowance.setClothingAllowance(rs.getDouble("clothingAllowance"));
                allowance.setEffectiveDate(rs.getDate("effectiveDate"));
                list.add(allowance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Allowance getById(int id) {
        String sql = "SELECT * FROM allowance WHERE allowanceID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Allowance allowance = new Allowance();
                allowance.setAllowanceID(rs.getInt("allowanceID"));
                allowance.setEmployeeID(rs.getInt("employeeID"));
                allowance.setRiceSubsidy(rs.getDouble("riceSubsidy"));
                allowance.setPhoneAllowance(rs.getDouble("phoneAllowance"));
                allowance.setClothingAllowance(rs.getDouble("clothingAllowance"));
                allowance.setEffectiveDate(rs.getDate("effectiveDate"));
                return allowance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Allowance allowance) {
        String sql = "INSERT INTO allowance (employeeID, riceSubsidy, phoneAllowance, clothingAllowance, effectiveDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, allowance.getEmployeeID());
            stmt.setDouble(2, allowance.getRiceSubsidy());
            stmt.setDouble(3, allowance.getPhoneAllowance());
            stmt.setDouble(4, allowance.getClothingAllowance());
            stmt.setDate(5, allowance.getEffectiveDate());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Allowance allowance) {
        String sql = "UPDATE allowance SET employeeID=?, riceSubsidy=?, phoneAllowance=?, clothingAllowance=?, effectiveDate=? WHERE allowanceID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, allowance.getEmployeeID());
            stmt.setDouble(2, allowance.getRiceSubsidy());
            stmt.setDouble(3, allowance.getPhoneAllowance());
            stmt.setDouble(4, allowance.getClothingAllowance());
            stmt.setDate(5, allowance.getEffectiveDate());
            stmt.setInt(6, allowance.getAllowanceID());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM allowance WHERE allowanceID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
