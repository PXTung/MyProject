package com.springmvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.UserDTO;
import com.springmvc.service.IUserService;

@Controller(value="UserControllerOfAdmin")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "admin/user/list", method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView mav = new ModelAndView("admin/user/list");
		UserDTO model = new UserDTO();
		model.setListResult(userService.findAll());
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="/admin/user/edit", method=RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		return mav;
	}
}
