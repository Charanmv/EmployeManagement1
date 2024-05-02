package com.employe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employe.dao.EmployeDao;

public class UserDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		System.out.println("User delete servlet ");
		// Retrieve user ID to be deleted
		
		int userId = Integer.parseInt(request.getParameter("id"));
		
		EmployeDao dao = new EmployeDao();
		
		String result = dao.deleteUserById(userId);
		// Printing result in the console
		System.out.println(result);
		// Printing response in the browser
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>" + result + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
