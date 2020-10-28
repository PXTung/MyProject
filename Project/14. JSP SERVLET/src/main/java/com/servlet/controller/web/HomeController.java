package com.servlet.controller.web;

import com.servlet.model.UserModel;
import com.servlet.service.IUserService;
import com.servlet.utils.FormUtils;
import com.servlet.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/home", "/login", "/logout"})
public class HomeController extends HttpServlet{

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 1126440908140437075L;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			UserModel userModel = FormUtils.toModel(UserModel.class, req);
			userModel = userService.checkUser(userModel.getUserName(), userModel.getPassword(), 1);
			if(userModel != null){
				SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
				if(userModel.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}else if(userModel.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/home");
				}
			}else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&message=user_password_invalid&alert=danger");
			}

		}
	}
}
