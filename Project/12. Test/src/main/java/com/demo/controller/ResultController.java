package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "result")
public class ResultController {
	@RequestMapping(value = "/helloajax", method = RequestMethod.GET)
	@ResponseBody
	public String helloAjax() {
		return "HELLO AJAX";
	}
}
