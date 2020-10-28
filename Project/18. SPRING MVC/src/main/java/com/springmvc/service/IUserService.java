package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.UserDTO;

public interface IUserService {

	UserDTO save(UserDTO dto);
	UserDTO findOne(Long id);
	void delete(Long id);
	List<UserDTO> findAll();
}
