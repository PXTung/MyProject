package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.converter.NewsConverter;
import com.springboot.dto.NewsDTO;
import com.springboot.entity.CategoryEntity;
import com.springboot.entity.NewsEntity;
import com.springboot.repository.ICategoryRepository;
import com.springboot.repository.INewsRepository;
import com.springboot.service.INewsService;

@Service
public class NewsService implements INewsService {

	@Autowired
	private INewsRepository newsRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private NewsConverter newsConverter;
	
	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		NewsEntity updateNews = new NewsEntity();
		CategoryEntity category = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		if(newsDTO.getId() != null) {
			NewsEntity oldNews = newsRepository.findOne(newsDTO.getId());
			updateNews = newsConverter.toEntity(newsDTO, oldNews);
		}else {
			updateNews = newsConverter.toEntity(newsDTO);
		}
		updateNews.setCategory(category);
		updateNews = newsRepository.save(updateNews);
		newsDTO = newsConverter.toDto(updateNews);
		newsDTO.setCategoryCode(category.getCode());
		return newsDTO;
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			newsRepository.delete(id);
		}
	}
}
