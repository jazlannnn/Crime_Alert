/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.model;

/**
 *
 * @author Jazlan
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusDAO {
    private static final String INSERT_STATUS_QUERY = "INSERT INTO status (status_id, status, report_id) VALUES (?, ?, ?)";

    public static void insertStatus(StatusBean statusBean) throws SQLException {
        try (Connection connection = // get your connection here
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATUS_QUERY)) {

            // Set values for the parameters
            preparedStatement.setInt(1, statusBean.getStatusId());
            preparedStatement.setString(2, statusBean.getStatus());
            preparedStatement.setInt(3, statusBean.getReportId());

            // Execute the insert query
            preparedStatement.executeUpdate();
        }
    }
}
