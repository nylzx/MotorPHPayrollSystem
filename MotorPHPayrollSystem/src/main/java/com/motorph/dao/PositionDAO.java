package com.motorph.dao;

import com.motorph.model.Position;
import com.motorph.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {
    public List<Position> getAll() {
        List<Position> list = new ArrayList<>();
        String sql = "SELECT * FROM position_table";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Position p = new Position(
                    rs.getInt("positionID"),
                    rs.getString("positionName"),
                    rs.getDouble("dailyRate")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
