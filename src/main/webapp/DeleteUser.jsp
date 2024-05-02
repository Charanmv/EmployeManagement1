<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Delete User</h2>
<form action="UserDeleteServlet" method="post">
<label for="id">User ID:</label><br>
<input type="text" id="id" name="id"><br><br>
<input type="submit" value="Delete User">
</form>

</body>
</html>