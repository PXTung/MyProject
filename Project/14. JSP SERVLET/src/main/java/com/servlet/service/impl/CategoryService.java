package com.servlet.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.servlet.dao.ICategoryDAO;
import com.servlet.model.CategoryModel;
import com.servlet.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public CategoryModel findOne(Long id) {
		// TODO Auto-generated method stub
		return categoryDAO.findone(id);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		// TODO Auto-generated method stub
		return categoryDAO.findOneByCode(code);
	}

}
