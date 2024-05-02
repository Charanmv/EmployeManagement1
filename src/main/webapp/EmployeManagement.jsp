<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
</head>
<jsp:include page = "Header.jsp"/>
<body>
<h1>Employee Management</h1>
<a href="EmployeForm.jsp">Insert Data</a><br><br>
<a href="GetById.jsp">Get Data By ID</a><br><br>
<a href="UpdateUser.jsp">Update User Data</a><br><br>
<a href="DeleteUser.jsp">Delete User Data</a><br><br>
<a href="GetAll.jsp">Get All User Data</a><br><br>
</body>
<jsp:include page = "Footer.jsp"/>
</html>