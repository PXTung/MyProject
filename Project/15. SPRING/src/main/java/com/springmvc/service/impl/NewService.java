package com.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.converter.NewsConverter;
import com.springmvc.dto.NewsDTO;
import com.springmvc.entity.CategoryEntity;
import com.springmvc.entity.NewsEntity;
import com.springmvc.repository.ICategoryRepository;
import com.springmvc.repository.INewsRepository;
import com.springmvc.service.INewService;

@Service
public class NewService implements INewService{

	@Autowired
	private INewsRepository newsRepository;
	
	@Autowired
	private NewsConverter newsConverter;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> news = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		for(NewsEntity item : entities) {
			NewsDTO newsDTO = newsConverter.toDTO(item);
			news.add(newsDTO);
		}
		return news;
	}

	@Override
	public int getTotalItem() {
		return (int) newsRepository.count();
	}

	@Override
	public NewsDTO findById(long id) {
		NewsEntity entity = newsRepository.findOne(id);
		return newsConverter.toDTO(entity);
	}

	@Override
	@Transactional
	public NewsDTO save(NewsDTO dto) {
		NewsEntity newsEntity = new NewsEntity();
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		if(dto.getId() != null) {
			newsEntity = newsRepository.findOne(dto.getId());
			newsEntity = newsConverter.toEntity(newsEntity, dto);
		}else {
			newsEntity = newsConverter.toEntity(dto);
		}
		newsEntity.setCategory(category);
		return newsConverter.toDTO(newsRepository.save(newsEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id : ids) {
			newsRepository.delete(id);
		}
	}
}
