<!-- userDetails.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <link rel="stylesheet" href="details.css">
</head>
<body>
<div class="details-contain">
    <h1>User Details</h1>
    

    <% 
        // Retrieve user details from the session
        String userId = (String) session.getAttribute("userId"); // fixed the key to "userId"
        String name = (String) session.getAttribute("username");
        Integer age = (Integer) session.getAttribute("age");
        Long phoneNumber = (Long) session.getAttribute("phoneNumber");
        Float currentBalance = (Float) session.getAttribute("currentBalance");
    %>
<form action="transactionHistory" method="post">
    <table class="user-info">
        <tr>
            <td class="label">User Id</td> <!-- Corrected label text -->
            <td class="label">:</td>
            <td class="value"><%= userId %></td>
        </tr>
        <tr>
            <td class="label">Name</td>	
            <td class="label">:</td>
            <td class="value"><%= name %></td>
        </tr>
        <tr>
            <td class="label">Age</td>
            <td class="label">:</td>
            <td class="value"><%= age %></td>
        </tr>
        <tr>
            <td class="label">Phone Number</td>
            <td class="label">:</td>
            <td class="value"><%= phoneNumber %></td>
        </tr>
        <tr>
            <td class="label">Current Balance</td>
            <td class="label">:</td>
            <td class="value">$<%= currentBalance %></td>
        </tr>
    </table>
   
    <div class="input-group">
    
        <button ><a href="transaction.jsp">Money Transaction</a></button>
         <button >Transaction Details</button>
        
        
        </div>
       <div class="logout">
    <p>Log out of your bank account <a href="login.jsp">Logout</a></p>
</div></form>

</div>
</body>
</html>
