package com.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.entity.CategoryEntity;
import com.springmvc.repository.ICategoryRepository;
import com.springmvc.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public Map<String, String> findAll() {
		Map<String, String> categories = new HashMap<String, String>();
		List<CategoryEntity> entity = categoryRepository.findAll();
		for(CategoryEntity item : entity) {
			categories.put(item.getCode(), item.getName());
		}
		return categories;
	}

	

}
