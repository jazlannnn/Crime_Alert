/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;

import com.alert.dao.ReportDAO;
import com.alert.model.ReportBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jazlan
 */
public class OlderReportServlet extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ReportDAO report = new ReportDAO();
        List<ReportBean> reports = report.getAllOlderReport();
        
        request.setAttribute("reports", reports);
        request.getRequestDispatcher("olderReport.jsp").forward(request,response);

    }

   

   

}
