<%-- 
    Document   : register
    Created on : 18-Oct-2020, 8:27:11 PM
    Author     : Cashton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="" method="POST">
            <input type="text" name="user" value="${user}">
            <input type="submit" value="register">
            <input type="hidden" name="action" value="register">
        </form>
        
    </body>
</html>
