/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class AdminLoginServlet extends HttpServlet {

    
  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String email =request.getParameter("email");
        String password = request.getParameter("password");
     
        HttpSession session =request.getSession();
        RequestDispatcher dispatcher=null;
         
          Connection con = null;
        try {
            String driver="org.apache.derby.jdbc.ClientDriver";
            String connectionString = "jdbc:derby://localhost:1527/crimelert;create=true;user=app;password=app";       
            Class.forName(driver);
            con = DriverManager.getConnection(connectionString);
         
         
         PreparedStatement pst = con.prepareStatement("SELECT * FROM ADMIN WHERE email = ? AND password = ?");
         pst.setString(1, email);
         pst.setString(2, password);
                  
                  
         ResultSet rs = pst.executeQuery();
         if(rs.next()){
             session.setAttribute("Adminname", rs.getString("username"));
             session.setAttribute("Amail", rs.getString("email"));
             session.setAttribute("Aid", rs.getLong("id"));
             session.setAttribute("Apassword", rs.getString("password"));
             session.setAttribute("Aaddress", rs.getString("address"));
             session.setAttribute("AphoneNum", rs.getString("phoneNum"));
             
             dispatcher = request.getRequestDispatcher("adminIndex.jsp");
             // Set attribute to "success" when login is successful
            request.setAttribute("status", "success");
            
            // Log or print a message to confirm that the status is set to success
            System.out.println("Login successful. Status set to success.");
             
         }else{
             request.setAttribute("status", "failed");
             dispatcher = request.getRequestDispatcher("adminLogin.jsp");
         }
         dispatcher.forward(request,response);

        } catch (Exception e) {
        }
         
      
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
