<%-- 
    Document   : register.jsp
    Created on : Jun 20, 2018, 2:55:15 PM
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
        <form action="Register" method="post">
            First name: <input type="text" value="" name="firstName">
            <br>
            Last name: <input type="text" value="" name="lastName">
            <br>
            Phone number: <input type="text" value="+381" name="phoneNumber">
            <br>
            Email: <input type="text" value="" name="email">
            <br>
            Password: <input type="password" value="" name="password">
            <input type="submit" name="register" value="Register">
        </form>
    </body>
</html>
