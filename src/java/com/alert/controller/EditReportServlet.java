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
import java.util.List;
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
        // Assuming "cid" is a Long, not an int
    int reportId = Integer.parseInt(request.getParameter("reportId"));

        // Retrieve the report details using ReportDAO
        ReportDAO reportDAO = new ReportDAO();
        ReportBean report = reportDAO.getReportById(reportId);

        // Set the report as an attribute in the request
        request.setAttribute("reports", report);  // Convert the ReportBean into a List

        // Forward the request to the editReport.jsp page
        request.getRequestDispatcher("/editReport.jsp").forward(request, response);
    }
}
