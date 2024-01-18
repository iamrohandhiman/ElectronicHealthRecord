<%@ page import="java.sql.*" %>
<%@ page import="com.example.DBConnector" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="container mt-5">

<%
    // Check if the user is logged in
    HttpSession userSession = request.getSession();
    Integer userId = (Integer) userSession.getAttribute("user_id");

    if (userId == null) {
        // Redirect to the login page if the user is not logged in
        response.sendRedirect("login.jsp");
    } else {
        // User is logged in, retrieve and display all patient data
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Obtain a database connection
            connection = DBConnector.getConnection();

            // Retrieve all patient details for the logged-in user
            String query = "SELECT * FROM patient_details WHERE user_id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            out.println("<div class='jumbotron'>");

            // Display patient details
            if (resultSet.next()) {
                out.println("<h2 class='display-4'>Patient Information</h2>");

                // Iterate over all columns and display the data
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                out.println("<ul class='list-group'>");

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String value = resultSet.getString(i);

                    out.println("<li class='list-group-item'><strong>" + columnName + ":</strong> " + value + "</li>");
                }

                out.println("</ul>");
            } else {
                out.println("<p>No patient information found for the logged-in user.</p>");
            }

            out.println("</div>");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>

<!-- Add Bootstrap JS and Popper.js scripts -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
