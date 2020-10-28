package com.bookmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookmanagement.model.Person;

@Controller
public class HomeController{

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	@RequestMapping(value = "addreader", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> addUser() {
		List<Person> ls = new ArrayList<Person>();
		ls.add(new Person("id", "name", "", "", ""));
		
		return ls;
	}
}
