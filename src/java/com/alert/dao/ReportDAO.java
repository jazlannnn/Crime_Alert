/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.dao;

import com.alert.model.ReportBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raimi
 */
public class ReportDAO {
    
    private static final String URL = "jdbc:derby://localhost:1527/crimelert";
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    public static int insertReport(ReportBean report) throws SQLException {
        
        ResultSet rs = null;
        int generatedReportId = -1;
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO report ( email, description, reportDate, status, userId) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                
                preparedStatement.setString(1, report.getEmail());
                preparedStatement.setString(2, report.getDescription());
                
                preparedStatement.setDate(3, report.getReportDate());
                
                preparedStatement.setString(4, report.getStatus());
                
                preparedStatement.setInt(5, report.getUserId());

                preparedStatement.executeUpdate();
                
                
                 try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
        if (generatedKeys.next()) {
             generatedReportId = generatedKeys.getInt(1);
            return generatedReportId;
        } else {
            throw new SQLException("Insertion failed, no generated keys obtained.");
        }
    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedReportId;

    }
    }
    
    public static List<ReportBean> getAllReportsUser(int userId) {
        List<ReportBean> reports = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT reportId ,email, description, reportDate, status FROM REPORT WHERE userId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    
                    while (resultSet.next()) {
                        ReportBean report = new ReportBean();
                        report.setReportId(resultSet.getInt("reportId"));
                        report.setEmail(resultSet.getString("email"));
                        report.setDescription(resultSet.getString("description"));
                        report.setReportDate(resultSet.getDate("reportDate"));
                        report.setStatus(resultSet.getString("status"));
                        report.setUserId(userId);

                        reports.add(report);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reports;
    }
    public static List<ReportBean> getAllReports() {
        List<ReportBean> reports = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT reportId ,email, description, reportDate, status FROM REPORT";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
               

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    
                    while (resultSet.next()) {
                        ReportBean report = new ReportBean();
                        report.setReportId(resultSet.getInt("reportId"));
                        report.setEmail(resultSet.getString("email"));
                        report.setDescription(resultSet.getString("description"));
                        report.setReportDate(resultSet.getDate("reportDate"));
                        report.setStatus(resultSet.getString("status"));
                        

                        reports.add(report);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reports;
    }
    public static ReportBean getReportById(int reportId) {
    ReportBean report = null;
    
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "SELECT reportId, email, description, reportDate, status, userId FROM report WHERE reportId = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reportId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    report = new ReportBean();
                    report.setReportId(reportId);
                    report.setEmail(resultSet.getString("email"));
                    report.setDescription(resultSet.getString("description"));
                    report.setReportDate(resultSet.getDate("reportDate"));
                    report.setStatus(resultSet.getString("status"));
                    report.setUserId(resultSet.getInt("userId"));
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return report;
}
    public static void updateReport(ReportBean report) {
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "UPDATE report SET email = ?, description = ?, reportDate = ?, status = ? WHERE reportId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, report.getEmail());
            preparedStatement.setString(2, report.getDescription());
            preparedStatement.setDate(3, report.getReportDate());
            preparedStatement.setString(4, report.getStatus());
            preparedStatement.setInt(5, report.getReportId());

            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public static void updateReportStatus(ReportBean report) {
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "UPDATE report SET status = ? WHERE reportId = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set status at index 1
            preparedStatement.setString(1, report.getStatus());
            // Set reportId at index 2
            preparedStatement.setInt(2, report.getReportId());

            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
   public static void deleteReport(int reportId) throws SQLException {
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "DELETE FROM report WHERE reportId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reportId);
                        

            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // rethrow the exception after logging
    }
}


    
    public static int CountDoneReport(){
      
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        int count = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "SELECT COUNT(*) FROM REPORT WHERE status = 'Done'";

           
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception as needed
        } 

        return count;
    }
    
    public static int CountNotDoneReport(){
      
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        int count = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "SELECT COUNT(*) FROM REPORT WHERE status = 'Not Done'";

           
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception as needed
        } 

        return count;
    }
    
    public static int CountInProgressReport(){
      
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        int count = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "SELECT COUNT(*) FROM REPORT WHERE status = 'InProgress'";

           
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception as needed
        } 

        return count;
    }
    
     public static int CountAllUser(){
      
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        int count = 0;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
        String sql = "SELECT COUNT(*) FROM CUSTOMER";

           
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception as needed
        } 

        return count;
    }
    
    
    
    
    
}
    
    
