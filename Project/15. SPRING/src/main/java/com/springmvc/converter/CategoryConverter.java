package com.springmvc.converter;

import org.springframework.stereotype.Component;

import com.springmvc.dto.CategoryDTO;
import com.springmvc.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		return dto;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
}
