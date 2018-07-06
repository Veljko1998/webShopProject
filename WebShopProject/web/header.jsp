<%-- 
    Document   : navbar.jsp
    Created on : Jun 19, 2018, 7:54:12 PM
    Author     : Veljko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <div class="logo">
                <img src="images/praviLogo.png">
            </div>
            <h1>Welcome to MPT Online Shop</h1>
            <ul class="navbar">
                <li><a href="#">Home</a></li>
                <li><a href="#">Info</a></li>
                <li><a href="#">FAQ</a></li>
                <li id="desniFloat"><a href="register.jsp">Register</a></li>
                <li id="desniFloat"><a href="login.jsp">Login</a></li>
            </ul>
        </div>
    </body>
</html>
