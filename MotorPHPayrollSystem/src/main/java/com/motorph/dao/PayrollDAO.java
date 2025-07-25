package com.motorph.dao;

import com.motorph.model.Payroll;
import com.motorph.util.DBConnection;
import java.sql.*;
import java.util.*;
public class PayrollDAO {
    public List<Payroll> getAll() {
        List<Payroll> list = new ArrayList<>();
        String sql = "SELECT * FROM Payroll";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Payroll payroll = new Payroll();
                payroll.setPayrollID(rs.getInt("payrollID"));
                payroll.setEmployeeID(rs.getInt("employeeID"));
                payroll.setSalaryID(rs.getInt("salaryID"));
                payroll.setDeductionID(rs.getInt("deductionID"));
                payroll.setAllowanceID(rs.getInt("allowanceID"));
                payroll.setPayPeriodID(rs.getInt("payPeriodID"));
                payroll.setWorkHours(rs.getDouble("workHours"));
                payroll.setOvertimeHours(rs.getDouble("overtimeHours"));
                payroll.setGrossPay(rs.getDouble("grossPay"));
                payroll.setNetPay(rs.getDouble("netPay"));
                list.add(payroll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Payroll getById(int id) {
        String sql = "SELECT * FROM Payroll WHERE payrollID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Payroll payroll = new Payroll();
                payroll.setPayrollID(rs.getInt("payrollID"));
                payroll.setEmployeeID(rs.getInt("employeeID"));
                payroll.setSalaryID(rs.getInt("salaryID"));
                payroll.setDeductionID(rs.getInt("deductionID"));
                payroll.setAllowanceID(rs.getInt("allowanceID"));
                payroll.setPayPeriodID(rs.getInt("payPeriodID"));
                payroll.setWorkHours(rs.getDouble("workHours"));
                payroll.setOvertimeHours(rs.getDouble("overtimeHours"));
                payroll.setGrossPay(rs.getDouble("grossPay"));
                payroll.setNetPay(rs.getDouble("netPay"));
                return payroll;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean insert(Payroll payroll) {
        String sql = "INSERT INTO Payroll (payrollID, employeeID, salaryID, deductionID, allowanceID, payPeriodID, workHours, overtimeHours, grossPay, netPay) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, payroll.getPayrollID());
            stmt.setObject(2, payroll.getEmployeeID());
            stmt.setObject(3, payroll.getSalaryID());
            stmt.setObject(4, payroll.getDeductionID());
            stmt.setObject(5, payroll.getAllowanceID());
            stmt.setObject(6, payroll.getPayPeriodID());
            stmt.setObject(7, payroll.getWorkHours());
            stmt.setObject(8, payroll.getOvertimeHours());
            stmt.setObject(9, payroll.getGrossPay());
            stmt.setObject(10, payroll.getNetPay());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Payroll payroll) {
        String sql = "UPDATE Payroll SET employeeID=?, salaryID=?, deductionID=?, allowanceID=?, payPeriodID=?, workHours=?, overtimeHours=?, grossPay=?, netPay=? WHERE payrollID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, payroll.getEmployeeID());
            stmt.setObject(2, payroll.getSalaryID());
            stmt.setObject(3, payroll.getDeductionID());
            stmt.setObject(4, payroll.getAllowanceID());
            stmt.setObject(5, payroll.getPayPeriodID());
            stmt.setObject(6, payroll.getWorkHours());
            stmt.setObject(7, payroll.getOvertimeHours());
            stmt.setObject(8, payroll.getGrossPay());
            stmt.setObject(9, payroll.getNetPay());
            stmt.setObject(10, payroll.getPayrollID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM Payroll WHERE payrollID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     *
     * @param 
     * @return
     */
    public Payroll getByEmployeeID(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
