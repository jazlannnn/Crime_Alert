/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;

import com.alert.model.ReportBean;
import com.alert.model.ReportDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raimi
 */
public class UpdateReportServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get parameters from the request
         int reportId = Integer.parseInt(request.getParameter("reportId"));
//        String userIdString = request.getParameter("userId");
//        int userId = Integer.parseInt(userIdString);
        
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        String reportDateString = request.getParameter("reportDate");
        Date reportDate = Date.valueOf(reportDateString); 
        String status = request.getParameter("status");
           

        
        //ReportBean object with the updated information
        ReportBean updatedReport = new ReportBean();
        updatedReport.setReportId(reportId);
//        updatedReport.setUserId(userId);
        updatedReport.setEmail(email);
        updatedReport.setDescription(description);
        updatedReport.setReportDate(reportDate);
        updatedReport.setStatus(status);

        // Update the report using ReportDAO
        ReportDAO.updateReport(updatedReport);

        // Redirect to a success page or display a success message
        response.sendRedirect("success.jsp"); // You can change "success.jsp" to your success page
    }
        
        
        
        
    }

   

