<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

<!-- SweetAlert CSS -->
<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">

<body>
    <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="assets/CRIMELERT.png" alt="sing up image">
						</figure>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Admin Login</h2>
                                                
						<form method="POST" action="AdminLoginServlet" class="register-form" id="login-form">
							<div class="form-group">
								<label for="Email"><i class="zmdi zmdi-account material-icons-name"></i></label> 
                                                                <input type="text" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> 
                                                                <input type="password" name="password" id="password" placeholder="Password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me" class="agree-term" /> 
                                                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin" class="form-submit" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<!-- jQuery -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<!-- SweetAlert -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
	<!-- Your main.js script -->
	<script src="js/main.js"></script>
        
       <script type="text/javascript">
           console.log("Script is running");
    var status = document.getElementById("status").value;
    
    if (status === "success") {
        Swal.fire({
            title: 'Congrats',
            text: 'Account login Successfully',
            icon: 'success',
        });
    }
    
    </script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>