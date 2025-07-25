package com.motorph.dao;

import com.motorph.model.Salary;
import com.motorph.util.DBConnection;
import java.sql.*;
import java.util.*;
public class SalaryDAO {
    public List<Salary> getAll() {
        List<Salary> list = new ArrayList<>();
        String sql = "SELECT * FROM Salary";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Salary salary = new Salary();
                salary.setSalaryID(rs.getInt("salaryID"));
                salary.setEmployeeID(rs.getInt("employeeID"));
                salary.setBaseSalary(rs.getDouble("baseSalary"));
                salary.setGrossSemiMonthlyRate(rs.getDouble("grossSemiMonthlyRate"));
                salary.setHourlyRate(rs.getDouble("hourlyRate"));
                list.add(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Salary getById(int id) {
        String sql = "SELECT * FROM Salary WHERE salaryID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Salary salary = new Salary();
                salary.setSalaryID(rs.getInt("salaryID"));
                salary.setEmployeeID(rs.getInt("employeeID"));
                salary.setBaseSalary(rs.getDouble("baseSalary"));
                salary.setGrossSemiMonthlyRate(rs.getDouble("grossSemiMonthlyRate"));
                salary.setHourlyRate(rs.getDouble("hourlyRate"));
                return salary;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean insert(Salary salary) {
        String sql = "INSERT INTO Salary (salaryID, employeeID, baseSalary, grossSemiMonthlyRate, hourlyRate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, salary.getSalaryID());
            stmt.setObject(2, salary.getEmployeeID());
            stmt.setObject(3, salary.getBaseSalary());
            stmt.setObject(4, salary.getGrossSemiMonthlyRate());
            stmt.setObject(5, salary.getHourlyRate());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Salary salary) {
        String sql = "UPDATE Salary SET employeeID=?, baseSalary=?, grossSemiMonthlyRate=?, hourlyRate=? WHERE salaryID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, salary.getEmployeeID());
            stmt.setObject(2, salary.getBaseSalary());
            stmt.setObject(3, salary.getGrossSemiMonthlyRate());
            stmt.setObject(4, salary.getHourlyRate());
            stmt.setObject(5, salary.getSalaryID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM Salary WHERE salaryID = ?";
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
