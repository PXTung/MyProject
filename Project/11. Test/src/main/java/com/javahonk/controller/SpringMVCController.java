package com.javahonk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringMVCController {
	@RequestMapping(value = "/helloWorld.web", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		model.addAttribute("message", "Return List in response");
		return "helloWorld";

	}

	@RequestMapping(value = "/returnListInResponse.web", method = RequestMethod.GET)
	public @ResponseBody List<String> returnListInResponse(@RequestParam("name") String name) {

		List<String> list = new ArrayList<String>();
		if (name.equalsIgnoreCase("Java Honk")) {
			for (int i = 0; i < 10; i++) {
				list.add("Java");
				list.add("Honk");
				list.add("Test");
			}

		} else {
			for (int i = 0; i < 10; i++) {
				list.add("Name is not Java Honk");
			}
		}

		return list;
	}
}