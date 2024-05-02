package com.employe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employe.model.Employe;


public class EmployeDao {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/EmployeManagement";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Charan@99";

	public void createEmploye(Employe emp) {
		Connection conn = null;
		PreparedStatement statement =null;


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO employe (fname, lname, age) VALUES (?, ?, ?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, emp.getFname());
			statement.setString(2, emp.getLname());
			statement.setInt(3, emp.getAge());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Method to Get Data BY ID
	public Employe getUserDetailsById(int id) {

		Employe employee = null;
		String query = "SELECT * FROM Employe WHERE Id = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

				PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				int ids = rs.getInt("id");
				String fname=rs.getString("fname");
				String lname = rs.getString("lname");
				int age = rs.getInt("Age");

				employee = new Employe(fname,lname,age,ids);

			}
			statement.close();
			conn.close();
		}


		catch (SQLException e) {
			e.printStackTrace();
		} 
		return employee;

	}

	// Method to delete user by ID
	public String deleteUserById(int userId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM employe WHERE id=?")) {
			stmt.setInt(1, userId);
			int res = stmt.executeUpdate();
			if (res > 0) {
				return "User Successfully Deleted";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Something went wrong";
	}


	// Method to update user information
	public String updateForm(Employe userForm) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("UPDATE employe SET fname=?, lname=?, age=? WHERE id=?")) {

			stmt.setString(1, userForm.getFname());
			stmt.setString(2, userForm.getLname());
			stmt.setInt(3, userForm.getAge());
			stmt.setInt(4, userForm.getId());

			int res = stmt.executeUpdate();
			if (res > 0) {
				return "User Successfully Updated";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Something went wrong";
	}


	//		----------------------------------------------

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (first_name, last_name, age) VALUES (?, ?, ?)";

	public String addEmployee(Employe employee) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
			preparedStatement.setString(1, employee.getFname());
			preparedStatement.setString(2, employee.getLname());
			preparedStatement.setInt(3, employee.getAge());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				return "Employee added successfully.";
			} else {
				return "Failed to add employee.";
			}
		} catch (SQLException e) {
			return "SQL Exception: " + e.getMessage();
		}
	}


	public List<Employe> getAllEmployee(){
		List<Employe> list = new ArrayList<Employe>();
		String query = "Select * from Employe";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String fname =rs.getString("fname");
				String lname =rs.getString("lname");
				int age = rs.getInt("age");
				Employe obj = new Employe(fname,lname,age,id);
				list.add(obj);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	
	}

	









