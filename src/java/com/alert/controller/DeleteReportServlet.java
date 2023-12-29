/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;

import com.alert.model.ReportDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raimi
 */
public class DeleteReportServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get reportId from request parameter
            int reportId = Integer.parseInt(request.getParameter("reportId"));

            // Call deleteReport method from ReportDAO
            ReportDAO.deleteReport(reportId);

            // Redirect back to the viewReport or any other appropriate page
            response.sendRedirect("viewReport.jsp");
        } catch (Exception e) {
            // Handle exceptions (e.g., log or show an error page)
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

