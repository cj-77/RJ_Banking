<!-- login.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Login</title>
    <!-- Link to the external CSS file -->
    <link rel="stylesheet" href="loginn.css">
</head>
<body>
<div class="login-con">
    <h1>New Account Creatting</h1>
    
    <!-- Display error message if login fails -->
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <div class="error-message">
            <p><%= errorMessage %></p>
        </div>
    <%
        }
    %>
    
    <form action="Sigup" method="post">
        <div class="input-group">
            <label for="username">User name</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="input-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="input-group">
            <label for="ReEnterpassword">ReEnter Password</label>
            <input type="password" id="ReEnterpassword" name="ReEnterpassword" required>
        </div>
         <div class="input-group">
            <label for="name">name</label>
            <input type="text" id="name" name="name" required>
        </div>
         <div class="input-group">
            <label for="Age">Age</label>
            <input type="text" id="Age" name="Age" required>
        </div>
         <div class="input-group">
            <label for="PhoneNumber">Phone Number</label>
            <input type="text" id="PhoneNumber" name="PhoneNumber" required>
        </div>
         <div class="input-group">
            <label for="Amount">Amount</label>
            <input type="text" id="Amount" name="Amount" required>
        </div>
        <button type="submit">Login</button>
       <p class="signup" style="color: #555;">Don't have an account? 
   <a href="login.jsp" style="color: #0066cc;">Sign In</a>
</p>

    </form>
</div>
</body>
</html>
