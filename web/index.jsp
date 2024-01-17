<%-- 
    Document   : test
    Created on : Dec 25, 2023, 10:18:00 PM
    Author     : raimi
--%>



<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect("login.jsp");
    }


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
        <title>Crimelert Home Page </title>
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
                <main class="container mt-4">
                    <h1 class="text-center">Welcome to Crime Alert System</h1>
                    <p class="lead text-center">Empowering Communities, Enhancing Safety</p>

                    <div class="row">
                        <div class="col-md-12">
                            <img src="assets/line.png" class="img-fluid" alt="Responsive image">
                        </div>
                    </div>

                    <div class="card mt-4 shadow">
                        <div class="card-body">
                            <h2 class="text-center">What is Crime Alert System?</h2>
                            <p class="lead">
                                Crime alert system is a comprehensive framework designed to swiftly communicate information about criminal activities to relevant stakeholders. This system typically includes mechanisms for reporting crimes, notifying the public, and collaborating with law enforcement agencies. Utilizing various communication channels, such as mobile apps, social media, and traditional media, a crime alert system aims to enhance public safety, facilitate timely responses to criminal incidents, and encourage community involvement in crime prevention. The system may incorporate technologies like GIS for mapping crime data and analytics tools to identify patterns, ultimately contributing to more effective crime prevention and law enforcement efforts.
                            </p>
                        </div>
                    </div>

                    <div class="row mt-4">
                        <div class="col-md-4">
                            <div class="card h-100 shadow">
                                <img src="assets/crime3.jpg" class="card-img-top img-fluid" alt="Featured Incident">
                                <div class="card-body">
                                    <h3 class="card-title">Featured Incidents</h3>
                                    <p class="card-text">
                                        Explore recent incidents in your community. Stay up-to-date on resolved cases and ongoing investigations. Your awareness helps build a safer environment for everyone.
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="card h-100 shadow">
                                <img src="assets/crime4.jpg" class="card-img-top img-fluid" alt="Community Statistics">
                                <div class="card-body">
                                    <h3 class="card-title">Community Statistics</h3>
                                    <p class="card-text">
                                        Our collective efforts make a difference. Check out the latest statistics on reported incidents, resolved cases, and the overall safety of our community.
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="card h-100 shadow">
                                <img src="assets/crime6.jpg" class="card-img-top img-fluid" alt="Safety Tips">
                                <div class="card-body">
                                    <h3 class="card-title">Safety Tips</h3>
                                    <p class="card-text">
                                        Your safety matters. Explore our tips on crime prevention, emergency preparedness, and community awareness. Together, we can create a secure living environment.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
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

