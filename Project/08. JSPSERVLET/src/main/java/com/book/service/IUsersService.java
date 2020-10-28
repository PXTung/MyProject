package com.book.service;

import java.util.List;

import com.book.model.Users;

public interface IUsersService {
	List<Users> findAll();
	Users add(Users user);
}
