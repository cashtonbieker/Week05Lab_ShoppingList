<%-- 
    Document   : shoppinglist
    Created on : 18-Oct-2020, 8:27:37 PM
    Author     : Cashton
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <h2>Hello ${user}</h2>
        <br>
        <a href="<c:url value='/shoppinglist'>
               <c:param name='action' value='logout'></c:param>
           </c:url>">Log Out</a>
        
        <h3>Add item:</h3>
        <form action="" method="POST">
            <input type="text" name="item" value="${item}">
            <input type="submit" name="addItem" value="add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="POST">
            <ul>
                <c:forEach items="${items}" var="item">
                <li><input type="radio" name="listItem" value="${item}"/>${item}</li>
                </c:forEach>
            </ul>
                
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
                
        </form>
    </body>
</html>
