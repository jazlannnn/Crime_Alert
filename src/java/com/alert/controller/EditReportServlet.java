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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raimi
 */
public class EditReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve reportId from request parameters
        int reportId = Integer.parseInt(request.getParameter("reportId"));

        // Fetch report details from the database using the ReportDAO
        ReportBean report = ReportDAO.getReportById(reportId);

        // Set the report details as an attribute in the request
        request.setAttribute("report", report);

        // Forward the request to the editReport.jsp page
        request.getRequestDispatcher("/editReport.jsp").forward(request, response);
    }
    }     
//        try{
//        // Retrieve form data
//        int reportId = Integer.parseInt(request.getParameter("ReportId"));
//        String email = request.getParameter("email");
//        String description = request.getParameter("description");
//        
//         String reportDateStr = request.getParameter("reportDate");
//         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//         java.util.Date utilDate = dateFormat.parse(reportDateStr);
//         java.sql.Date reportDate = new java.sql.Date(utilDate.getTime());
//         String status = request.getParameter("status");
//
//
//            
//        int userId = Integer.parseInt(request.getParameter("userId"));
//        HttpSession session = request.getSession();
//        session.setAttribute("userId", userId);
//        
//        
//        // Create a ReportBean object and set the updated values
//        ReportBean updatedReport = new ReportBean();
//        updatedReport.setReportId(reportId);
//        updatedReport.setEmail(email);
//        updatedReport.setDescription(description);
//        updatedReport.setReportDate(reportDate);
//        updatedReport.setStatus(status);
//        
//        updatedReport.setUserId(userId);
//
//   
//        // Update the report using the DAO
//        ReportDAO.updateReport(updatedReport);
//        response.sendRedirect("success.jsp");
//        
//        }catch (NumberFormatException e) {
//        // Handle the case where "cid" is not a valid Long
//        e.printStackTrace(); // Log or handle the exception appropriately
//        response.sendRedirect("error.jsp"); // Redirect to an error page
//    }   catch (ParseException ex) {
//            Logger.getLogger(EditReportServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    

