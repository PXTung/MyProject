package com.ajaxdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ajaxdemo.model.Person;

@Controller
public class HomeController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("views/web/home");
		return mav;
	}
	
	@RequestMapping(value = "person", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> getPerson() {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Tung", "25"));
		list.add(new Person("Tung", "25"));
		list.add(new Person("Tung", "25"));
		return list;
	}

}
