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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raimi
 */
public class registerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

     String email   = request.getParameter("email");
     String username   = request.getParameter("username");
     String password   = request.getParameter("password");
     String address   = request.getParameter("address");
     String phoneNum   = request.getParameter("phoneNum");
     Connection con = null;
     RequestDispatcher dispatcher =null;
     
     PrintWriter out = response.getWriter();
     try{
//         Class.forName("org.apache.derby.jdbc.ClientDriver");
//         con = DriverManager.getConnection("jdbc:derby://localhost:8080/crimelert;user=crime;password=123");
         
          String driver="org.apache.derby.jdbc.ClientDriver";
            String connectionString = "jdbc:derby://localhost:1527/crimelert;create=true;user=app;password=app";       
            Class.forName(driver);
            con = DriverManager.getConnection(connectionString);
         
         
         PreparedStatement pst = con.prepareStatement("insert into customer(email,username,password,address,phoneNum) values(?,?,?,?,?)");
         
         pst.setString(1,email);
         pst.setString(2,username);
         pst.setString(3,password);
         pst.setString(4,address);
         pst.setString(5,phoneNum);
         
         int rowCount = pst.executeUpdate();
         dispatcher = request.getRequestDispatcher("register.jsp");
         if (rowCount>0){
             request.setAttribute("status","success");
             
         }else{
             request.setAttribute("status", "failed");
         }
         
         dispatcher.forward(request, response);
          
     } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Error: Database connection error.");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
