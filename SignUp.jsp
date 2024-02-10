<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>SignUp</title>
	<link rel="stylesheet" href="styles1.css">
	</head>
	<body>
	  <div class="signup-container">
        <form class="signup-form" action="SignUpServlet" method="post">
            <h2>Sign Up</h2>
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" required>
            </div>
            
            <div class="input-group">
                <label for="role">Role</label>
                <input type="text" id="role" name="role" required>
            </div>
            <button type="submit">Sign Up</button>
        </form>
    </div>

	</body>
</html>