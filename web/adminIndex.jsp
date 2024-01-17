<%-- 
    Document   : test
    Created on : Dec 25, 2023, 10:18:00 PM
    Author     : raimi
--%>



<%@page import="com.alert.dao.ReportDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
    if (session.getAttribute("Adminname") == null) {
        response.sendRedirect("adminLogin.jsp");
    }

    int CountDone = ReportDAO.CountDoneReport();
    int CountNotDoneReport = ReportDAO.CountNotDoneReport();
    int CountInProgressReport = ReportDAO.CountInProgressReport();
    int CountAllUser = ReportDAO.CountAllUser();


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
        <title>Crimelert Admin Dashboard</title>
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

                    <!-- ... Your existing code ... -->

                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">CRIME ALERT!!!!</li>
                        </ol>

                        <div>
                            <img src="assets/line.png" class="img-fluid" alt="Responsive image">
                        </div>

                        <!-- New row for cards -->
                        <div class="row mt-4">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Report Done: <%= CountDone%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="viewUserReport.jsp">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Report Not Done: <%= CountNotDoneReport%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="viewUserReport.jsp">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Report Inprogress: <%= CountInProgressReport%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="viewUserReport.jsp">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-info text-white mb-4">
                                    <div class="card-body">Total User: <%= CountAllUser%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="ViewUser">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <div class="embed-responsive embed-responsive-16by9">
                                        <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15936.146753880605!2d101.49071259635495!3d3.084883350503627!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31cc4d80707fe6bf%3A0xcb1a37071040c156!2sShah%20Alam%20District%20Police%20Headquarters!5e0!3m2!1sen!2smy!4v1705514858141!5m2!1sen!2smy" 
                                                width="1200" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- ... Your existing code ... -->

                </main>
                <!-- Include footer -->
                <%@ include file="footer.jsp" %>
            </div>
        </div>

        <!-- Include scripts and additional dependencies -->
        <!-- ... -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>

