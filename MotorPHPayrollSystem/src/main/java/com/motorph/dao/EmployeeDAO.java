package com.motorph.dao;

import com.motorph.model.Employee;
import com.motorph.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeID(rs.getInt("employeeID"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setDepartment(rs.getString("department"));
                emp.setPosition(rs.getString("position"));
                emp.setRatePerDay(rs.getDouble("ratePerDay"));
                emp.setEmail(rs.getString("email"));
                emp.setContactNumber(rs.getString("contactNumber"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Employee getById(int id) {
        String sql = "SELECT * FROM Employee WHERE employeeID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeID(rs.getInt("employeeID"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setDepartment(rs.getString("department"));
                emp.setPosition(rs.getString("position"));
                emp.setRatePerDay(rs.getDouble("ratePerDay"));
                emp.setEmail(rs.getString("email"));
                emp.setContactNumber(rs.getString("contactNumber"));
                return emp;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Optional: used in login by first name
    public Employee getByUsername(String username) {
        String sql = "SELECT * FROM Employee WHERE firstName = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeID(rs.getInt("employeeID"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setDepartment(rs.getString("department"));
                emp.setPosition(rs.getString("position"));
                emp.setRatePerDay(rs.getDouble("ratePerDay"));
                emp.setEmail(rs.getString("email"));
                emp.setContactNumber(rs.getString("contactNumber"));
                return emp;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(Employee emp) {
        String sql = "INSERT INTO Employee (employeeID, firstName, lastName, department, position, ratePerDay, email, contactNumber) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emp.getEmployeeID());
            stmt.setString(2, emp.getFirstName());
            stmt.setString(3, emp.getLastName());
            stmt.setString(4, emp.getDepartment());
            stmt.setString(5, emp.getPosition());
            stmt.setDouble(6, emp.getRatePerDay());
            stmt.setString(7, emp.getEmail());
            stmt.setString(8, emp.getContactNumber());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Employee emp) {
        String sql = "UPDATE Employee SET firstName=?, lastName=?, department=?, position=?, ratePerDay=?, email=?, contactNumber=? WHERE employeeID=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setString(3, emp.getDepartment());
            stmt.setString(4, emp.getPosition());
            stmt.setDouble(5, emp.getRatePerDay());
            stmt.setString(6, emp.getEmail());
            stmt.setString(7, emp.getContactNumber());
            stmt.setInt(8, emp.getEmployeeID());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int employeeID) {
        String sql = "DELETE FROM Employee WHERE employeeID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeID);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
