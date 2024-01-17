/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.controller;

import com.alert.dao.adminDAO;
import com.alert.model.customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raimi
 */
public class ViewUserServlet extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        adminDAO admin = new adminDAO();
        List<customer> users = admin.getAllUser();
        
        request.setAttribute("users", users);

        request.getRequestDispatcher("/displayUsers.jsp").forward(request, response);
        
        
    }



}
