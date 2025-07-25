package com.motorph.util;

import com.motorph.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuthenticator {

    public static boolean authenticate(int employeeID, String password) {
        return authenticate(password, "");
    }

    public static boolean authenticate(String password, String secret123) {
        String sql = "SELECT password FROM user_accounts WHERE employeeID = ?";
        try (Connection conn = DBConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            int employeeID = 0;
            stmt.setInt(1, employeeID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                // Use PasswordUtils if you hash passwords
                return storedPassword.equals(password);
                // If using hashes: return PasswordUtils.verify(password, storedPassword);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
