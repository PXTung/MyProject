package com.sum.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sum.model.NumberAdd;

@WebServlet(urlPatterns = { "/home", "/sum" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -892178850933529653L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number1 = req.getParameter("number1");
		String number2 = req.getParameter("number2");
		int sum = Integer.parseInt(number1) + Integer.parseInt(number2);
		new NumberAdd(number1, number2, "" + sum);

		resp.sendRedirect(req.getContextPath() + "/home");
	}
}
