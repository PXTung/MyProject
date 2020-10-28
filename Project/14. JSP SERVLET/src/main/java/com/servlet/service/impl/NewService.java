package com.servlet.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.servlet.dao.INewDAO;
import com.servlet.model.CategoryModel;
import com.servlet.model.NewModel;
import com.servlet.paging.IPageble;
import com.servlet.service.ICategoryService;
import com.servlet.service.INewService;

public class NewService implements INewService{

	@Inject
	private INewDAO newDAO;
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDAO.findByCategoryId(categoryId);
	}
	
	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryService.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(categoryModel.getId());
		Long id = newDAO.save(newModel);
		return newDAO.findOne(id);
	}

	@Override
	public NewModel update(NewModel updateNews) {
		NewModel oldNews = newDAO.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryService.findOneByCode(updateNews.getCategoryCode());
		updateNews.setCategoryId(categoryModel.getId());
		newDAO.update(updateNews);
		return newDAO.findOne(updateNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			newDAO.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(IPageble pageble) {
		return newDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}

	@Override
	public NewModel findOne(Long id) {
		NewModel newModel = newDAO.findOne(id);
		CategoryModel categoryModel = categoryService.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}
}
