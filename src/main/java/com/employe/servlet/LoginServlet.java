package com.employe.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employe.dao.UserDao;
import com.employe.model.Mysqlinfo;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private UserDao UserDao;

    public void init() {
    	UserDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
            ServletContext ctx = getServletContext();
		
     		String JDBC_URL = ctx.getInitParameter("JDBC_URL");
     		String USERNAME = ctx.getInitParameter("USERNAME");
     		String PASSWORD = ctx.getInitParameter("PASSWORD");
     		
     		Mysqlinfo obj = new Mysqlinfo(JDBC_URL,USERNAME,PASSWORD);


        if (UserDao.validate(email, password,obj)) {
            // Login successful, redirect to employeeList.jsp
            response.sendRedirect("EmployeManagement.jsp");
        } else {
            // Login failed, redirect back to login.jsp
            response.sendRedirect("login.jsp");
        }
    }
}

