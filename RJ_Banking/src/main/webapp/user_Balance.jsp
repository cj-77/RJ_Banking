<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Page</title>
    <link rel="stylesheet" href="BalanceAmount.css">
</head>
<body>
    <div class="Balance_Amounte">
        <h1>Current Balance</h1>
        <% 
        // Retrieve user details from the session
        Float currentBalance = (Float) session.getAttribute("currentBalance");
    %>
        <table class="user-info">
            <tr>
                <td class="label">Current balance</td>
                <td class="label">:</td>
                <td class="value"><%= currentBalance %></td>
            </tr>
        </table>
        
        <!-- Form for the transaction process -->
 
        <div class="input-group">
            <a href="userDetails.jsp" class="button">Home Page</a>
            <a href="login.jsp" class="button">Log out</a>
        </div>
    </div>
</body>
</html>
