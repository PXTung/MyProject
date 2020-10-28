package com.document.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.document.dao.ReaderDAO;
import com.document.model.Person;
import com.document.model.Reader;

@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}

	@RequestMapping(value = "add-reader", method = RequestMethod.GET)
	@ResponseBody
	public String addReader(HttpServletRequest request) {
		String perId = request.getParameter("perId");
		String perName = request.getParameter("perName");
		String perAddress = request.getParameter("perAddress");
		String perDob = request.getParameter("perDob");
		String perGender = request.getParameter("perGender");
		String redId = request.getParameter("redId");
		String redType = request.getParameter("redType");
		String redPhone = request.getParameter("redPhone");
		String redEmail = request.getParameter("redEmail");
		
		Person person = new Person(perId, perName, perAddress, perDob, perGender);
		Reader reader = new Reader(person, redId, redType, redPhone, redEmail);
		
		ReaderDAO.getInstance().add(reader);
		
		return "Add Success ";
	}

	@RequestMapping(value = "get-list-reader", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> getListReader() {
		List<Person> readers = ReaderDAO.getInstance().show();
		return readers;
	}
}
