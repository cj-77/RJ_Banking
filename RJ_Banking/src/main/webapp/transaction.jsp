<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Page</title>
    <link rel="stylesheet" href="combined.css">
</head>
<body>
        <!-- Display error message if login fails -->
   
    <div class="transaction-container">
        <div class="tab-buttons">
        
               
            <button class="tab-link active" onclick="openTab(event, 'Deposit')">Deposit Amount</button>
            <button class="tab-link" onclick="openTab(event, 'Withdraw')">Withdraw Amount</button>
        </div>
                
        <div id="Deposit" class="tab-content">
            <div class="deposite">
                <h1>Deposit Amount</h1>
                <form action="deposit" method="post">
                    <div class="input-group">
                        <label for="deposit-amount">Enter Amount:</label>
                        <input type="text" id="deposit-amount" name="amount" required>
                    </div>
                    <div class="input-group">
                        <button type="submit" name="action" value="deposit">Deposit Amount</button>
                    </div>
                </form>
                <div class="input-group">
                    <button><a href="user_Balance.jsp" class="button">Check Balance</a></button>
                </div>
                <div class="input-group">
                    <button><a href="withdrow.jsp" class="button">Withdraw Balance</a></button>
                </div>
                <div class="input-group">
                    <button><a href="userDetails.jsp" class="button">Home Page</a></button>
                </div>
            </div>
        </div>

        <div id="Withdraw" class="tab-content" style="display:none;">
            <div class="Withdraw_Amount">
             <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <div class="error-message" style="color: #cc1818;>
    <p "><%= errorMessage %></p>
</div>

    <%
        }
    %>
                <h1>Withdraw Amount</h1>
                <form action="withdraw-amount" method="post">
                    <div class="input-group">
                        <label for="withdraw-amount">Enter Amount:</label>
                        <input type="text" id="withdraw-amount" name="amount" required>
                    </div>
                    <div class="input-group">
                        <button type="submit" name="action" value="withdraw">Withdraw Amount</button>
                    </div>
                </form>
                <div class="input-group">
                    <button><a href="user_Balance.jsp" class="button">Check Balance</a></button>
                </div>
                <div class="input-group">
                    <button><a href="deposit.jsp" class="button">Deposit Balance</a></button>
                </div>
                <div class="input-group">
                    <button><a href="userDetails.jsp" class="button">Home Page</a></button>
                </div>
            </div>
        </div>
    </div>

    <script>
    
        function openTab(event, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tab-content");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tab-link");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabName).style.display = "block";
            event.currentTarget.className += " active";
        }
    </script>
</body>
</html>
