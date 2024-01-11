/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;

import com.alert.model.customer;
import com.alert.model.customerDAO;
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
 * @author raimi
 */
public class customerSettingServlet extends HttpServlet {

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
       String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNum");
        
        HttpSession session = request.getSession();
        long customerId = (long) session.getAttribute("cid"); // Assuming customer ID is stored in the session
        
        customerDAO customer = new customerDAO();

        // Update user settings
        boolean updated = customer.updateUserSettings(customerId, username, email, password, address, phoneNum);

        if (updated) {
            // Settings updated successfully
            // Update session attributes with new values
            session.setAttribute("name", username);
            session.setAttribute("mail", email);

            response.sendRedirect("success.jsp"); // Redirect to a success page
        } else {
            // Handle the case where the update failed
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
        
        
        
    }

    

}
