package com.servlet.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servlet.model.NewModel;
import com.servlet.model.UserModel;
import com.servlet.service.INewService;
import com.servlet.utils.HttpUtil;
import com.servlet.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewAPI extends HttpServlet {

	private static final long serialVersionUID = 1779360605958022970L;
	
	@Inject
	private INewService newService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		newModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		newModel = newService.save(newModel);
		objectMapper.writeValue(resp.getOutputStream(), newModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewModel updateNews = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		updateNews.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		updateNews = newService.update(updateNews);
		objectMapper.writeValue(resp.getOutputStream(), updateNews);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());
		objectMapper.writeValue(resp.getOutputStream(), "{}");
	}
}
