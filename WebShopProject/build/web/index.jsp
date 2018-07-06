<%-- 
    Document   : index.jsp
    Created on : Jun 19, 2018, 7:48:36 PM
    Author     : Veljko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
         <%@include file="header.jsp" %>
         <%@include file="sidebar.jsp" %>
         <p><a href="prikaz.jsp">Prikaz</a></p>
         <%if(true) {System.out.println("nesto");
         } %>
         <%@include file="footer.jsp" %>
    </body>
</html>
