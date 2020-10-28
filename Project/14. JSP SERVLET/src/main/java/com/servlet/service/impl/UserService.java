package com.servlet.service.impl;

import javax.inject.Inject;

import com.servlet.dao.IUserDAO;
import com.servlet.model.UserModel;
import com.servlet.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel checkUser(String userName, String passWord, Integer status) {
		return userDAO.checkUser(userName, passWord, status);
	}

}
