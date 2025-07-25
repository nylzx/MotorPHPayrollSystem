package com.motorph.dao;

import com.motorph.model.Deduction;
import com.motorph.util.DBConnection;
import java.sql.*;
import java.util.*;
public class DeductionDAO {
    public List<Deduction> getAll() {
        List<Deduction> list = new ArrayList<>();
        String sql = "SELECT * FROM Deduction";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Deduction deduction = new Deduction();
                deduction.setDeductionID(rs.getInt("deductionID"));
                deduction.setEmployeeID(rs.getInt("employeeID"));
                deduction.setSalary_min(rs.getDouble("salary_min"));
                deduction.setSalary_max(rs.getDouble("salary_max"));
                deduction.setSssDeduction(rs.getDouble("sssDeduction"));
                deduction.setPhilhealthRate(rs.getDouble("philhealthRate"));
                deduction.setPagDeduction(rs.getDouble("pagDeduction"));
                deduction.setTaxBase(rs.getDouble("taxBase"));
                deduction.setTaxRate(rs.getDouble("taxRate"));
                list.add(deduction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Deduction getById(int id) {
        String sql = "SELECT * FROM Deduction WHERE deductionID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Deduction deduction = new Deduction();
                deduction.setDeductionID(rs.getInt("deductionID"));
                deduction.setEmployeeID(rs.getInt("employeeID"));
                deduction.setSalary_min(rs.getDouble("salary_min"));
                deduction.setSalary_max(rs.getDouble("salary_max"));
                deduction.setSssDeduction(rs.getDouble("sssDeduction"));
                deduction.setPhilhealthRate(rs.getDouble("philhealthRate"));
                deduction.setPagDeduction(rs.getDouble("pagDeduction"));
                deduction.setTaxBase(rs.getDouble("taxBase"));
                deduction.setTaxRate(rs.getDouble("taxRate"));
                return deduction;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean insert(Deduction deduction) {
        String sql = "INSERT INTO Deduction (deductionID, employeeID, salary_min, salary_max, sssDeduction, philhealthRate, pagDeduction, taxBase, taxRate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, deduction.getDeductionID());
            stmt.setObject(2, deduction.getEmployeeID());
            stmt.setObject(3, deduction.getSalary_min());
            stmt.setObject(4, deduction.getSalary_max());
            stmt.setObject(5, deduction.getSssDeduction());
            stmt.setObject(6, deduction.getPhilhealthRate());
            stmt.setObject(7, deduction.getPagDeduction());
            stmt.setObject(8, deduction.getTaxBase());
            stmt.setObject(9, deduction.getTaxRate());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Deduction deduction) {
        String sql = "UPDATE Deduction SET employeeID=?, salary_min=?, salary_max=?, sssDeduction=?, philhealthRate=?, pagDeduction=?, taxBase=?, taxRate=? WHERE deductionID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, deduction.getEmployeeID());
            stmt.setObject(2, deduction.getSalary_min());
            stmt.setObject(3, deduction.getSalary_max());
            stmt.setObject(4, deduction.getSssDeduction());
            stmt.setObject(5, deduction.getPhilhealthRate());
            stmt.setObject(6, deduction.getPagDeduction());
            stmt.setObject(7, deduction.getTaxBase());
            stmt.setObject(8, deduction.getTaxRate());
            stmt.setObject(9, deduction.getDeductionID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM Deduction WHERE deductionID = ?";
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
