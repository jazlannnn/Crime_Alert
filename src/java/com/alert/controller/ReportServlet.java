/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;

import com.alert.model.ReportBean;
import com.alert.dao.ReportDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raimi
 */
public class ReportServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{ 
         // Retrieve data from the form
        
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        
         String reportDateStr = request.getParameter("reportDate");
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date utilDate = dateFormat.parse(reportDateStr);
         java.sql.Date reportDate = new java.sql.Date(utilDate.getTime());
         String status = request.getParameter("status");


            
        int userId = Integer.parseInt(request.getParameter("userId"));
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);
        
        

        
//        System.out.println("UserId set in session: " + userId);
        ReportBean report = new ReportBean();
        report.setEmail(email);
        report.setDescription(description);
        report.setReportDate(reportDate);
        report.setStatus(status);
        
        report.setUserId(userId);

       
        
        int generatedReportId = ReportDAO.insertReport(report);
        if (generatedReportId != 0) {
    // Use generatedReportId as needed
    System.out.println("Generated Report ID: " + generatedReportId);

    //  store the reportId in session or pass it to other components
    session.setAttribute("generatedReportId", generatedReportId);
    session.setAttribute("reportId", report.getReportId());

    // Redirect to success.jsp or handle the success scenario
    response.sendRedirect("success.jsp");
} else {
    // Handle the case where reportId couldn't be generated
    response.sendRedirect("error.jsp");
}
    }catch (NumberFormatException e) {
        // Handle the case where "cid" is not a valid Long
        e.printStackTrace(); // Log or handle the exception appropriately
        response.sendRedirect("error.jsp"); // Redirect to an error page
    }   catch (ParseException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    

    }
}
