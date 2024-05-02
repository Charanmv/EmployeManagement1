package com.employe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employe.dao.EmployeDao;
import com.employe.model.Employe;


public class ProcessEmployeesServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instantiate DAO
        EmployeDao dao = new EmployeDao();
        
        // Get list of employees from DAO
        List<Employe> employees = dao.getAllEmployee();
        
        // Forward the list to JSP for display
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/displayEmployees.jsp").forward(request, response);
    }
}

