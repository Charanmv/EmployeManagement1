package com.employe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employe.dao.EmployeDao;
import com.employe.model.Employe;

public class GetByIdServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("I'm servlet of GetById");
		
		int id = Integer.parseInt(req.getParameter("id"));

		EmployeDao dao = new EmployeDao();


		
			Employe result = dao.getUserDetailsById(id);
		

		// Printing result in the console
		System.out.println(result);

		// Printing response in the browser
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>" + "User Data is successfully fetched" + "</h2>");
		out.println("Name =  " + result.getFname() + " Lastname = " + result.getLname() + " Age = "+ result.getAge());
		out.println("</body>");
		out.println("</html>");
	}

}
