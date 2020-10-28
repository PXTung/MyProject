package com.servlet.dao.impl;

import java.util.List;

import com.servlet.dao.IUserDAO;
import com.servlet.mapper.UserMapper;
import com.servlet.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel checkUser(String userName, String passWord, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(),  userName, passWord, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
