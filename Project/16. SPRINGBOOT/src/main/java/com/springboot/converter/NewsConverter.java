package com.springboot.converter;

import org.springframework.stereotype.Component;

import com.springboot.dto.NewsDTO;
import com.springboot.entity.NewsEntity;

@Component
public class NewsConverter {
	public NewsDTO toDto(NewsEntity entity) {
		NewsDTO model = new NewsDTO();
		model.setId(entity.getId());
		model.setTitle(entity.getTitle());
		model.setThumbnail(entity.getThumbnail());
		model.setShortDescription(entity.getShortDescription());
		model.setContent(entity.getContent());
		model.setCreatedBy(entity.getCreatedBy());
		model.setCreatedDate(entity.getCreatedDate());
		model.setModifiedBy(entity.getModifiedBy());
		model.setModifiedDate(entity.getModifiedDate());
		return model;
	}
	
	public NewsEntity toEntity(NewsDTO dto) {
		NewsEntity model = new NewsEntity();
		model.setTitle(dto.getTitle());
		model.setThumbnail(dto.getThumbnail());
		model.setShortDescription(dto.getShortDescription());
		model.setContent(dto.getContent());
		return model;
	}
	
	public NewsEntity toEntity(NewsDTO dto, NewsEntity model) {
		model.setTitle(dto.getTitle());
		model.setThumbnail(dto.getThumbnail());
		model.setShortDescription(dto.getShortDescription());
		model.setContent(dto.getContent());
		return model;
	}
}
