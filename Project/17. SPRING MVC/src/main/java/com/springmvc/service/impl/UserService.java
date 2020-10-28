package com.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.convert.UserConvert;
import com.springmvc.dto.UserDTO;
import com.springmvc.entity.UserEntity;
import com.springmvc.repository.IUserRepository;
import com.springmvc.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private UserConvert userConvert;
	
	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> users = new ArrayList<>();
		List<UserEntity> entity = userRepository.findAll();
		for(UserEntity e : entity) {
			UserDTO user = userConvert.toDto(e);
			users.add(user);
		}
		return users;
	}

	@Override
	public void delete(Long[] ids) {
		for(long id : ids) {
			userRepository.delete(id);
		}
	}

	@Override
	public UserDTO save(UserDTO user) {
		UserEntity entity = userConvert.toEntity(user);
		userRepository.save(entity);
		return user;
	}

}
