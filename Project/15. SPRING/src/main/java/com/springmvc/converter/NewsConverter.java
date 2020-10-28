package com.springmvc.converter;

import org.springframework.stereotype.Component;

import com.springmvc.dto.NewsDTO;
import com.springmvc.entity.NewsEntity;

@Component
public class NewsConverter {
	public NewsDTO toDTO(NewsEntity entity) {
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setId(entity.getId());
		newsDTO.setTitle(entity.getTitle());
		newsDTO.setShortDescription(entity.getShortDescription());
		newsDTO.setContent(entity.getContent());
		newsDTO.setThumbnail(entity.getThumbnail());
		newsDTO.setCategoryCode(entity.getCategory().getCode());
		return newsDTO;
	}
	
	public NewsEntity toEntity(NewsDTO dto) {
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setTitle(dto.getTitle());
		newsEntity.setShortDescription(dto.getShortDescription());
		newsEntity.setContent(dto.getContent());
		newsEntity.setThumbnail(dto.getThumbnail());
		return newsEntity;
	}
	
	public NewsEntity toEntity(NewsEntity newsEntity, NewsDTO dto) {
		newsEntity.setTitle(dto.getTitle());
		newsEntity.setShortDescription(dto.getShortDescription());
		newsEntity.setContent(dto.getContent());
		newsEntity.setThumbnail(dto.getThumbnail());
		return newsEntity;
	}
}
