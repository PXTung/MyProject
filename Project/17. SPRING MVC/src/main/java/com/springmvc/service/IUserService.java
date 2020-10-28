package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();

	void delete(Long[] ids);

	UserDTO save(UserDTO user);
}
