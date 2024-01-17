<%-- 
    Document   : editReport
    Created on : Dec 27, 2023, 12:38:30 AM
    Author     : raimi
--%>

<%@page import="com.alert.dao.ReportDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.alert.model.ReportBean"%>
<%
    if(session.getAttribute("name")==null){
        response.sendRedirect("login.jsp");
    }
    
//    Object emailAttribute = session.getAttribute("mail");
//    System.out.println("Email attribute from session: " + emailAttribute);
//    long customerId = (Long) session.getAttribute("cid");
//    System.out.println("id attribute from session: " + customerId);
//    
//    int reportId = Integer.parseInt(request.getParameter("reportId"));
//    
// Integer userId = (Integer) session.getAttribute("userId");//System.out.println("UserId retrieved from session: " + userId);
// 
// List<ReportBean> reports = ReportDAO.getAllReportsUser(userId);
// 
//System.out.println("Report ID: " + reportId);
//System.out.println("Email from session: " + emailAttribute);
//System.out.println("Customer ID from session: " + customerId);
//System.out.println("Description from request: " + request.getParameter("description"));
ReportBean reportToEdit = (ReportBean) request.getAttribute("reports");

%> 



<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!-- Add other meta tags as needed -->
        <title>Dashboard - SB Admin</title>
    </head>
    <body class="sb-nav-fixed">
        <!-- Include header -->
        <%@ include file="header.jsp" %>

        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <!-- Include sidebar -->
                <%@ include file="sidebar.jsp" %>
            </div>
           
            
            <div id="layoutSidenav_content">
                <main>
                 
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Report</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">CRIME ALERT!!!!</li>
                        </ol>
                            <div>
           <img src="assets/line.png" class="img-fluid" alt="Responsive image">
            </div>
                        
                        
                        
                        <div class="card">
                            <div class="card-body">
                              
                                <form action="UpdateReport" method="POST" >
                                    <input type="hidden" name="reportId" value="<%= request.getParameter("reportId") %>">
                                        <div class="form-row">
                                          <div class="form-group col-md-6">
 
                                            <label for="email">Email: <br><%= session.getAttribute("mail") %></label>
                                    <input type="hidden" class="form-control" id="email" name="email" value="<%= session.getAttribute("mail") %>">

                                          </div>
                                          <br> 
                                        </div>
                                        <div class="form-group"
                                          <label for="description">Issue</label>
                                            <input type="text" class="form-control" id="description"  name="description"  style="vertical-align: top;  height: 300px" placeholder="" value="<%= reportToEdit.getDescription()  %>">
                                        </div>
                                          <br>
                                          
                                          <div class="form-group"
                                                <label for="date">Date Crime:</label>
                                                <input type="date" class="form-control" id="reportDate"  name="reportDate" placeholder="" value="<%= reportToEdit.getReportDate()%>"
                                           </div>
                                          <br>
                                          <input type="hidden" name="status" value="Not Done">
                                           <input type="hidden" class="form-control" id="userId" name="userId" value="<%= session.getAttribute("cid")%>">
                                           
<!--                                        <div class="form-row">
                                          <div class="form-group col-md-6">
                                            <label for="status">status</label>
                                            <input type="text" class="form-control" id="status">
                                          </div>
                                          
                                         
                                        </div>-->
                                    
<!--                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <br><label for="zipdoc">Upload File: </label><br>
                                        <input type="file" name="zipdoc" value="" >
                                        </div>
                                    </div>-->
                               


                                    <br>
                                        <button type="submit" class="btn btn-primary">submit</button>
                                      </form>
                                
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

