package com.servlet.dao;

import java.util.List;

import com.servlet.model.NewModel;
import com.servlet.paging.IPageble;

public interface INewDAO extends IGenericDAO<NewModel> {
	List<NewModel> findByCategoryId(Long CategoryId);
	Long save(NewModel newModel); 
	NewModel findOne(Long id);
	void update(NewModel updateNew);
	void delete(Long id);
	List<NewModel> findAll(IPageble pageble);
	int getTotalItem();
}
