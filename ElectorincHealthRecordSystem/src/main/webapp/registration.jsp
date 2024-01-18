<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body class="container">

<%
    // Check if the user is already logged in
    if (session.getAttribute("user_id") != null) {
        // Redirect to the dashboard if the user is already logged in
        response.sendRedirect("dashboard.jsp");
    }
%>

<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <h2 class="text-center">Registration</h2>

        <form class="mt-3" action="registerUser" method="post">
            <div class="form-group">
                <label for="userId">User ID:</label>
                <input type="text" class="form-control" id="userId" name="userId" required>
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>
            <div class="form-group">
                <label for="role">Role:</label>
                <input type="text" class="form-control" id="role" name="role" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>

        <div class="mt-2">
            <!-- Add a link to the login page if already registered -->
            <span class="text-muted">Already registered? <a href="login.jsp">Click here to login</a></span>
        </div>
    </div>
</div>

<!-- Add Bootstrap JS and Popper.js scripts -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<!-- Include other scripts here if needed -->
</body>
</html>
