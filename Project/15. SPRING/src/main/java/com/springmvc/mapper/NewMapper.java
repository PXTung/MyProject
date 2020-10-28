package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.springmvc.model.NewModel;

public class NewMapper implements IRowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel newModel = new NewModel();
			newModel.setId(resultSet.getLong("id"));
			newModel.setTitle(resultSet.getString("title"));
			newModel.setContent(resultSet.getString("content"));
			newModel.setCategoryId(resultSet.getLong("categoryid"));
			newModel.setThumbnail(resultSet.getString("thumbnail"));
			newModel.setShortDescription(resultSet.getString("shortdescription"));
			newModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			newModel.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				newModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				newModel.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return newModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
