<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Update User</h2>
	<form action="UserUpdateServlet" method="post">
		<label for="id">User ID:</label><br> 
		<input type="text" id="id" name="id"><br> 
		<label for="fname">First Name:</label><br>
		<input type="text" id="fname" name="fname"><br> 
		<label for="lname">Last Name:</label><br> 
		<input type="text" id="lname" name="lname"><br> 
		<label for="age">Age:</label><br>
		<input type="text" id="age" name="age"><br>
		<br> <input type="submit" value="Update User">
	</form>

</body>
</html>