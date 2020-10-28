package com.springmvc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dto.UserDTO;
import com.springmvc.service.IUserService;

@RestController
public class UserAPI {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "api/admin/user")
	public UserDTO saveUser() {
		UserDTO user = new UserDTO();
		return userService.save(user);
	}
	
	@RequestMapping(value="api/admin/user", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@RequestBody Long[] ids) {
		userService.delete(ids);
	}
}
