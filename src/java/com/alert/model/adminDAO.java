/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
