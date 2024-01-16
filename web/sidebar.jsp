<%-- 
    Document   : sidebar
    Created on : Dec 25, 2023, 10:15:11 PM
    Author     : raimi
--%>
<%
//    Integer userId = (Integer) session.getAttribute("userId");
//System.out.println("UserId retrieved from session: " + userId);

    %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Detail</div>
                            <a class="nav-link" href="index.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Home Page
                            </a>
                             <a class="nav-link" href="createReport.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Create Report 
                            </a>
                             <a class="nav-link" href="ViewReport">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                View Report
                            </a>
                             <a class="nav-link" href="viewUserDetail.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                User Detail
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        <%= session.getAttribute("name") %>
                    </div>
                </nav>

