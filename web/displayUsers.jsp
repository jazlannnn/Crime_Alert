<%-- 
    Document   : displayUsers
    Created on : Jan 17, 2024, 12:49:39 AM
    Author     : raimi
--%>

<%@page import="com.alert.model.customer"%>
<%
   
    
    int i=1;

%> 

<%@ page import="java.util.List" %>
<%@ page import="com.alert.model.ReportBean" %>
<%@ page import="com.alert.dao.ReportDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!-- Add other meta tags as needed -->
        <title>Crimelert View Report</title>
    </head>
    <body class="sb-nav-fixed">
        <!-- Include header -->
        <%@ include file="adminHeader.jsp" %>

        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <!-- Include sidebar -->
                <%@ include file="adminSidebar.jsp" %>
            </div>
            
            
           
            
            <div id="layoutSidenav_content">
                <main>
                 
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">View All User</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">CRIME ALERT!!!!</li>
                        </ol>
                            <div>
           <img src="assets/line.png" class="img-fluid" alt="Responsive image">
            </div>
                        <div class="row">
                            <div class="card">
                        <div class="card-body">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Email</th>
                                        <th>Username</th>
<!--                                        <th>Password</th>-->
                                        <th>Address</th>
                                        <th>PhoneNumber</th>
                                        
                                       
                                    </tr>
                                </thead>
                                <%

                               List<customer> users = (List<customer>) request.getAttribute("users");
                               if (users != null && !users.isEmpty()){
                                for (customer user : users) {
                                %>
                                <tbody>
                                   
                                        <tr>
                                            <td><%= i++ %></td>
                                            <td><%= user.getEmail() %></td>
                                            <td><%= user.getUsername() %></td>
<!--                                            <td><%= user.getPassword() %></td>-->
                                            <td><%= user.getAddress() %></td>
                                            <td><%= user.getPhoneNum() %></td>
                                            
            
                               

<!--                                            <td><a href="editReport.jsp?reportId= report.getReportId() ">Edit</a></td>-->


                                           
                                            
                                        </tr>
                                    <% } %>
                                </tbody>
                            </table>
                                <%
            }
         else {
    %>
                        <tr>
                            <td colspan="8">
                                <p>No User found.</p>
                            </td>
                        </tr>
    <%
        }
    %>

                        </div>
                    </div>
                        
                    </div>
                </main>
                <%@ include file="footer.jsp" %>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>

