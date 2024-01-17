/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.dao;

import com.alert.model.customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jazlan
 */
public class adminDAO {
    
      private static final String URL = "jdbc:derby://localhost:1527/crimelert";
    private static final String USER = "app";
    private static final String PASSWORD = "app";
    
     public boolean updateAdminSettings(long adminId, String username, String email, String password, String address, String phoneNum) {
        try {
            // Connect to your database
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD );

            // Create a prepared statement for the update
            PreparedStatement pst = con.prepareStatement("UPDATE ADMIN SET username=?, email=?, password=?, address=?, phoneNum=? WHERE id=?");
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, address);
            pst.setString(5, phoneNum);
            pst.setLong(6, adminId);

            // Execute the update
            int rowsUpdated = pst.executeUpdate();

            // Close resources
            pst.close();
            con.close();

            // Check if the update was successful
            return rowsUpdated > 0;
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
            return false;
        }
    }
     
     public static List<customer> getAllUser() {
        List<customer> users = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM CUSTOMER";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
               

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    
                    while (resultSet.next()) {
                        customer user = new customer();
                        user.setId(resultSet.getLong("id"));
                        user.setEmail(resultSet.getString("email"));
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setAddress(resultSet.getString("address"));
                        user.setPhoneNum(resultSet.getString("phoneNum"));
                        
                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
}
