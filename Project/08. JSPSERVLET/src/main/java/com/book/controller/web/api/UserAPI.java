package com.book.controller.web.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.model.Users;
import com.book.service.IUsersService;
import com.book.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/api-user" })
public class UserAPI extends HttpServlet{
	
	@Inject
	private IUsersService userService;

	private static final long serialVersionUID = 650516793985977761L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Users user = HttpUtil.of(request.getReader()).toModel(Users.class);
		Users user1 = userService.add(user);
		mapper.writeValue(response.getOutputStream(), user);
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	
	public void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
