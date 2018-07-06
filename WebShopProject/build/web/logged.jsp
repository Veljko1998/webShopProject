<%-- 
    Document   : logged.jsp
    Created on : Jul 2, 2018, 4:40:23 PM
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
        <%@include file="header.jsp" %>
        <%@include file="sidebar.jsp" %>
        <h1>Prodavnica telefona</h1>
        <div class="searchLoginRegister">
            <input type="search" value="" name="search">
            <ul>
                <li><a href="index.jsp">Logout</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>
