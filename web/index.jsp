<%-- 
    Document   : test
    Created on : Dec 25, 2023, 10:18:00 PM
    Author     : raimi
--%>



<%
    if(session.getAttribute("name")==null){
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
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">CRIME ALERT!!!!</li>
                        </ol>
                            <div>
                                <img src="assets/line.png" class="img-fluid" alt="Responsive image">
                            </div>
                        <h1 class="mt-4">Welcome to Crime Alert System</h1>
                        <p class="lead">Empowering Communities, Enhancing Safety</p>
                        <p>
                            Crime Alert is a comprehensive system designed to keep communities informed and enhance public safety. Our platform provides a secure and user-friendly environment for users to report and access information about incidents happening in their neighborhoods.
                        </p>
                        <p>
                            Whether you are a concerned citizen or a law enforcement official, Crime Alert offers a centralized hub for reporting, tracking, and managing incidents. Stay connected, stay informed, and contribute to creating safer and more secure communities.
                        </p>
                        
                        <div class="mt-4">
                            <h2>Featured Incidents</h2>
                            <p>
                                Explore recent incidents in your community. Stay up-to-date on resolved cases and ongoing investigations. Your awareness helps build a safer environment for everyone.
                            </p>
                            <!-- Include a section displaying recent incidents -->
                        </div>
                        <div class="mt-4">
                            <h2>Community Statistics</h2>
                            <p>
                                Our collective efforts make a difference. Check out the latest statistics on reported incidents, resolved cases, and the overall safety of our community.
                            </p>
                            <!-- Include charts or graphs displaying community statistics -->
                        </div>
                        <div class="mt-4">
                            <h2>Safety Tips</h2>
                            <p>
                                Your safety matters. Explore our tips on crime prevention, emergency preparedness, and community awareness. Together, we can create a secure living environment.
                            </p>
                            <!-- Include a section with safety tips -->
                        </div>
                        <div>

                        <div class="slider-frame">
                            <div class="slide-images">
                                <div class="img-container">
                                    <img src="assets/crime.jpg">
                                </div>
                                <div class="img-container">
                                    <img src="assets/crime.jpg">
                                </div>
                                <div class="img-container">
                                    <img src="assets/crime.jpg">
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

