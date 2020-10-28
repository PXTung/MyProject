package com.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.model.NumberAdd;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 4263373799034280720L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");	
		int sum = Integer.parseInt(number1) + Integer.parseInt(number2);
		
		new NumberAdd(number1, number2, "" + sum);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}
}
