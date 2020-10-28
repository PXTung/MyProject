package com.springmvc.convert;

import org.springframework.stereotype.Component;

import com.springmvc.dto.RoleDTO;
import com.springmvc.dto.UserDTO;
import com.springmvc.entity.UserEntity;

@Component
public class UserConvert {
	public UserDTO toDto(UserEntity entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setFullName(entity.getFullName());
		dto.setUserName(entity.getUserName());
		dto.setStatus(entity.getStatus());
		dto.setPassWord(entity.getPassWord());
		RoleDTO role = new RoleDTO();
		role.setCode(entity.getRole().getCode());
		role.setName(entity.getRole().getName());
		dto.setRole(role);
		return dto;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setFullName(dto.getFullName());
		entity.setUserName(dto.getUserName());
		entity.setStatus(dto.getStatus());
		entity.setPassWord(dto.getPassWord());
		return entity;
	}
}
