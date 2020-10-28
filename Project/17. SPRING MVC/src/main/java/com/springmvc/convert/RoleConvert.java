package com.springmvc.convert;

import org.springframework.stereotype.Component;

import com.springmvc.dto.RoleDTO;
import com.springmvc.entity.RoleEntity;

@Component
public class RoleConvert {
	public RoleDTO toDto(RoleEntity entity) {
		RoleDTO dto = new RoleDTO();
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		return dto;
	}
	
	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}
