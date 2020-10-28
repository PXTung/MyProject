package com.book.dao;

import java.util.List;

import com.book.model.Users;

public interface IUsersDAO extends IGenericDAO{
	List<Users> findAll();
	int add(Users user);
	Users findOne(int id);
}
