/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;


import com.alert.model.adminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jazlan
 */
public class adminSettingServlet extends HttpServlet {

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNum");
        
        HttpSession session = request.getSession();
        long adminId = (long) session.getAttribute("Aid"); // Assuming customer ID is stored in the session
        
        adminDAO admin = new adminDAO();

        // Update user settings
        boolean updated = admin.updateAdminSettings(adminId, username, email, password, address, phoneNum);

        if (updated) {
            // Settings updated successfully
            // Update session attributes with new values
            session.setAttribute("Adminname", username);
            session.setAttribute("Amail", email);

            response.sendRedirect("AdminSuccess.jsp"); // Redirect to a success page
        } else {
            // Handle the case where the update failed
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
        
        
        
    }
}
