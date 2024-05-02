package com.employe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employe.model.Employe;
import com.employe.model.Mysqlinfo;

public class UserDao {
//	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
//	private static final String USERNAME = "root";
//	private static final String PASSWORD = "Charan@99";
	
	
	
	
	
	//Signup Dao method
	
		private static final String INSERT_USER_SQL = "INSERT INTO users (firstName, lastName, email, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";

	    public String UserModel(String firstName, String lastName, String email, String phoneNumber, String password, Mysqlinfo obj ) {
	    	
	    	
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    	} catch (ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    	
	        try (Connection connection = DriverManager.getConnection(obj.getJDBC_URL(), obj.getUSERNAME(), obj.getPASSWORD());
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

	            preparedStatement.setString(1, firstName);
	            preparedStatement.setString(2, lastName);
	            preparedStatement.setString(3, email);
	            preparedStatement.setString(4, phoneNumber);
	            preparedStatement.setString(5, password);

	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected > 0) {
	                return "SUCCESS";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return "FAIL";
	    }
	
	    private static final String SELECT_QUERY = "SELECT * FROM users WHERE email = ? AND password = ?";

	    public boolean validate(String email, String password,Mysqlinfo obj) {
	    	
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    	} catch (ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    	
	        try (Connection connection = DriverManager.getConnection(obj.getJDBC_URL(),obj.getUSERNAME(),obj.getPASSWORD());
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {

	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                // User exists in database
	                return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	
}
