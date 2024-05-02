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


public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao UserDao;

    public void init() {
    	UserDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        
        ServletContext ctx = getServletContext();
		
		String JDBC_URL = ctx.getInitParameter("JDBC_URL");
		String USERNAME = ctx.getInitParameter("USERNAME");
		String PASSWORD = ctx.getInitParameter("PASSWORD");
		
		Mysqlinfo obj = new Mysqlinfo(JDBC_URL,USERNAME,PASSWORD);


        if (password.equals(confirmPassword)) {
            String result = UserDao.UserModel(firstName, lastName, email, phoneNumber, password,obj);

            if (result.equals("SUCCESS")) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("signup.jsp");
            }
        } else {
            // Passwords do not match
            response.sendRedirect("signup.jsp");
        }
    }
}

