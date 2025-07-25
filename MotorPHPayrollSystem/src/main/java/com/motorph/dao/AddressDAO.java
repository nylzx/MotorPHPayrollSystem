package com.motorph.dao;

import com.motorph.model.Address;
import com.motorph.util.DBConnection;
import java.sql.*;
import java.util.*;
public class AddressDAO {
    public List<Address> getAll() {
        List<Address> list = new ArrayList<>();
        String sql = "SELECT * FROM Address";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Address address = new Address();
                address.setAddressID(rs.getInt("addressID"));
                address.setEmployeeID(rs.getInt("employeeID"));
                address.setAddressType(rs.getString("addressType"));
                address.setUnitNumber(rs.getString("unitNumber"));
                address.setBuildingName(rs.getString("buildingName"));
                address.setStreet(rs.getString("street"));
                address.setBarangay(rs.getString("barangay"));
                address.setCity(rs.getString("city"));
                address.setProvince(rs.getString("province"));
                address.setZipcode(rs.getString("zipcode"));
                list.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Address getById(int id) {
        String sql = "SELECT * FROM Address WHERE addressID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Address address = new Address();
                address.setAddressID(rs.getInt("addressID"));
                address.setEmployeeID(rs.getInt("employeeID"));
                address.setAddressType(rs.getString("addressType"));
                address.setUnitNumber(rs.getString("unitNumber"));
                address.setBuildingName(rs.getString("buildingName"));
                address.setStreet(rs.getString("street"));
                address.setBarangay(rs.getString("barangay"));
                address.setCity(rs.getString("city"));
                address.setProvince(rs.getString("province"));
                address.setZipcode(rs.getString("zipcode"));
                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean insert(Address address) {
        String sql = "INSERT INTO Address (addressID, employeeID, addressType, unitNumber, buildingName, street, barangay, city, province, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, address.getAddressID());
            stmt.setObject(2, address.getEmployeeID());
            stmt.setObject(3, address.getAddressType());
            stmt.setObject(4, address.getUnitNumber());
            stmt.setObject(5, address.getBuildingName());
            stmt.setObject(6, address.getStreet());
            stmt.setObject(7, address.getBarangay());
            stmt.setObject(8, address.getCity());
            stmt.setObject(9, address.getProvince());
            stmt.setObject(10, address.getZipcode());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Address address) {
        String sql = "UPDATE Address SET employeeID=?, addressType=?, unitNumber=?, buildingName=?, street=?, barangay=?, city=?, province=?, zipcode=? WHERE addressID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, address.getEmployeeID());
            stmt.setObject(2, address.getAddressType());
            stmt.setObject(3, address.getUnitNumber());
            stmt.setObject(4, address.getBuildingName());
            stmt.setObject(5, address.getStreet());
            stmt.setObject(6, address.getBarangay());
            stmt.setObject(7, address.getCity());
            stmt.setObject(8, address.getProvince());
            stmt.setObject(9, address.getZipcode());
            stmt.setObject(10, address.getAddressID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM Address WHERE addressID = ?";
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
