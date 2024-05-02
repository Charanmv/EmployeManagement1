<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Fname</th>
            <th>Lname</th>
            <th>Age</th>
            
        </tr>
        <c:forEach var="employe" items="${employees}">
            <tr>
                <td>${employe.id}</td>
                <td>${employe.fname}</td>
                <td>${employe.lname}</td>
                <td>${employe.age}</td>
              
            </tr>
        </c:forEach>
    </table>
</body>

</html>