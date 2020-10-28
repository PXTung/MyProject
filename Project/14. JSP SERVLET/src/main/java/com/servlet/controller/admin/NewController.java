package com.servlet.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.constant.SystemConstant;
import com.servlet.model.NewModel;
import com.servlet.paging.IPageble;
import com.servlet.paging.PageRequest;
import com.servlet.service.ICategoryService;
import com.servlet.service.INewService;
import com.servlet.sort.Sorter;
import com.servlet.utils.FormUtils;

@WebServlet(urlPatterns = "/admin-new")
public class NewController extends HttpServlet {

	private static final long serialVersionUID = -3104456442727027925L;

	@Inject
	private INewService newService;
	
	@Inject
	private ICategoryService categoryService;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModel newModel = FormUtils.toModel(NewModel.class, req);
		String view = "";
		if (newModel.getType().equals(SystemConstant.LIST)) {
			IPageble pageble = new PageRequest(newModel.getPage(), newModel.getMaxPageItem(),
					new Sorter(newModel.getSortName(), newModel.getSortBy()));
			newModel.setListResult(newService.findAll(pageble));
			newModel.setTotalItem(newService.getTotalItem());
			newModel.setTotalPage((int) Math.ceil((double) newModel.getTotalItem() / newModel.getMaxPageItem()));
			
			view = "views/admin/new/list.jsp";
		} else if(newModel.getType().equals(SystemConstant.EDIT)){
			if(newModel.getId() != null) {
				newModel = newService.findOne(newModel.getId());
			} else {
				
			}
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			view = "views/admin/new/edit.jsp";
			req.setAttribute("categories", categoryService.findAll());
		}
		req.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
