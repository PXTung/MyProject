package com.servlet.service;

import java.util.List;

import com.servlet.model.NewModel;
import com.servlet.paging.IPageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNews);
	void delete(long[] ids);
	List<NewModel> findAll(IPageble pageble);
	int getTotalItem();
	NewModel findOne(Long id);
}
