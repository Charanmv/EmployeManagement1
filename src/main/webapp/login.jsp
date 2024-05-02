<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
    <h2>Sign In</h2>
    <form action="login" method="post">
        <label for="email">Username:</label>
        <input type="text" id="email" name="email" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Sign In">
    </form>
</body>
</html>