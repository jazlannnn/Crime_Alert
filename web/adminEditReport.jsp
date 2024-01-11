<%@ page import="java.util.List" %>
<%@ page import="com.alert.model.ReportBean" %>
<%@ page import="com.alert.model.ReportDAO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<%
  String reportIdParam = request.getParameter("reportId");
System.out.println("report ID retrieved from request parameter: " + reportIdParam);

// Trim whitespace and then parse
int reportId = Integer.parseInt(reportIdParam.trim());

// Retrieve the report based on the report ID
ReportBean report = ReportDAO.getReportById(reportId);


%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Report - SB Admin</title>
    <!-- Add your stylesheets and other meta tags as needed -->
</head>
<body class="sb-nav-fixed">
    <!-- Include header -->
    <%@ include file="header.jsp" %>

    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <!-- Include sidebar -->
            <%@ include file="adminSidebar.jsp" %>
        </div>

        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Edit Report</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">CRIME ALERT!!!!</li>
                    </ol>

                    <div class="row">
                        <div class="card">
                            <div class="card-body">
                                <form action="UpdateReportStatus" method="post">
                                    <!-- Hidden input field to store the report ID -->
                                    <input type="hidden" name="reportId" value="<%= report.getReportId() %>">

                                    <div class="mb-3">
                                        <label for="status" class="form-label">Status</label>
                                        <select class="form-select" id="status" name="status">
                                            <option value="Not Done" <%= report.getStatus().equals("Not Done") ? "selected" : "" %>>Not Done</option>
                                            <option value="Done" <%= report.getStatus().equals("Done") ? "selected" : "" %>>Done</option>
                                            <option value="InProgress" <%= report.getStatus().equals("InProgress") ? "selected" : "" %>>InProgress</option>
                                        </select>
                                    </div>

                                    <button type="submit" class="btn btn-primary">Update Status</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <%@ include file="footer.jsp" %>
        </div>
    </div>

    <!-- Include your scripts and additional dependencies as needed -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
