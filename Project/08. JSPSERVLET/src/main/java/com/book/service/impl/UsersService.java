package com.book.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.book.dao.IUsersDAO;
import com.book.model.Users;
import com.book.service.IUsersService;

public class UsersService implements IUsersService{

	@Inject
	private IUsersDAO usersDAO;
	
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersDAO.findAll();
	}

	@Override
	public Users add(Users user) {
		int userId = usersDAO.add(user);
		return null;
	}

}
