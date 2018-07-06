<%-- 
    Document   : prikaz.jsp
    Created on : Jul 5, 2018, 3:33:14 AM
    Author     : Veljko
--%>
<%@page import="prepare.PrepareForDisplay"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= PrepareForDisplay.displayAllProducts() %>
    </body>
</html>
