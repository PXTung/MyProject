package com.servlet.dao;

import java.util.List;

import com.servlet.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	CategoryModel findone(Long id);
	CategoryModel findOneByCode(String code);
}
