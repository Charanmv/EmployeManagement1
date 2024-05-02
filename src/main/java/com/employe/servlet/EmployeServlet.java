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



public class EmployeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi all this is Servelet");
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		int age = Integer.parseInt(req.getParameter("age"));
	
		
		PrintWriter pr=resp.getWriter();
		pr.print("First Name :");
		pr.println(fname);
		
		pr.print("Last Name :");
		pr.println(lname);
		
		pr.print("Age :");
		pr.print(age);
		
		Employe obj = new Employe(fname,lname, age);
		
	    EmployeDao dao = new EmployeDao();
     	dao.createEmploye(obj);
   	}

}
