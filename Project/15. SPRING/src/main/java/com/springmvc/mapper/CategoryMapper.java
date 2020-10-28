package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.springmvc.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(resultSet.getLong("id"));
			categoryModel.setCode(resultSet.getString("code"));
			categoryModel.setName(resultSet.getString("name"));
			return categoryModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
