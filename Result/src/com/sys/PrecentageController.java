package com.sys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PrecentageController")
public class PrecentageController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String operation=request.getParameter("operation");
		
		out.println(operation);
		int yes=0;
		int no=0;
		if(operation.equalsIgnoreCase("YES")) {
			yes=1;
		} else if("NO".equalsIgnoreCase(operation)) {
			no=1;
		}
		Operation operation1=new Operation();
		operation1.add(yes, no);
		response.sendRedirect("Question.jsp");
	}

}
