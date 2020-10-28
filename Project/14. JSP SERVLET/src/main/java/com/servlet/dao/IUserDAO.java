package com.servlet.dao;

import com.servlet.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	UserModel checkUser(String userName, String passWord, Integer status);
}
