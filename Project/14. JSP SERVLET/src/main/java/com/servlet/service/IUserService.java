package com.servlet.service;

import com.servlet.model.UserModel;

public interface IUserService {
	UserModel checkUser(String userName, String passWord, Integer status);
}
