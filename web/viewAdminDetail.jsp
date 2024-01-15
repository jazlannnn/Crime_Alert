<%-- 
    Document   : test
    Created on : Dec 25, 2023, 10:18:00 PM
    Author     : raimi
--%>



<%
    if(session.getAttribute("Adminname")==null){
        response.sendRedirect("adminLogin.jsp");
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
        <title>Admin Detail </title>
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
                       
                        
                        <div>
                                <img src="assets/line.png" class="img-fluid" alt="Responsive image">
                        </div>
                        
                         <h1 class="mt-4">Admin Detail</h1>
                          <div class="card">
                            <div class="card-body">
                                <form method="POST" action="adminSetting">
                                 <div class="form-group">
                                    <label for="username">Username: </label>
                                    <label for="username"><%= session.getAttribute("Adminname") %></label>

                                </div>
                                <br>

                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <label for="email"><%= session.getAttribute("Amail") %></label>
                                </div>
                                <br>

                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <label for="password"><%= session.getAttribute("Apassword") %></label>
                                </div>
                                <br>

                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <label for="address"> <%= session.getAttribute("Aaddress") %></label>

                                </div>
                                <br>

                                <div class="form-group">
                                    <label for="phoneNum">Phone Number:</label>
                                     <label for="phoneNum"><%= session.getAttribute("AphoneNum") %></label>
                                </div>


                                <br>
                                
                                </form>
                                
                                
                                
                                
                              
                                
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

