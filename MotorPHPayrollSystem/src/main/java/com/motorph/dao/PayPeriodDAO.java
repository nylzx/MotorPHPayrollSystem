package com.motorph.dao;

import com.motorph.model.PayPeriod;
import com.motorph.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayPeriodDAO {

    public List<PayPeriod> getAll() {
        List<PayPeriod> list = new ArrayList<>();
        String sql = "SELECT * FROM pay_period";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PayPeriod period = new PayPeriod(
                    rs.getInt("payPeriodID"),
                    rs.getDate("startDate"),
                    rs.getDate("endDate")
                );
                list.add(period);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insert(PayPeriod period) {
        String sql = "INSERT INTO pay_period (startDate, endDate) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, period.getStartDate());
            stmt.setDate(2, period.getEndDate());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM pay_period WHERE payPeriodID=?";
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
