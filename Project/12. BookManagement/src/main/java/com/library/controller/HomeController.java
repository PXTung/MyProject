package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.Person;

@Controller
public class HomeController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	@RequestMapping(value = "person", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> getPerson() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("111", "Tung", "HN", "0809", "MEN"));
		return list;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "hello";
	}
}
