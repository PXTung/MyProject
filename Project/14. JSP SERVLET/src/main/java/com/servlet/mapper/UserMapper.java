package com.servlet.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.model.RoleModel;
import com.servlet.model.UserModel;

public class UserMapper implements IRowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel userModel = new UserModel();
		try {
			userModel.setId(resultSet.getLong("id"));
			userModel.setUserName(resultSet.getString("username"));
			userModel.setFullName(resultSet.getString("fullname"));
			userModel.setPassword(resultSet.getString("password"));
			userModel.setStatus(resultSet.getInt("status"));
			userModel.setRoleId(resultSet.getLong("roleid"));
			RoleModel role = new RoleModel();
			role.setCode(resultSet.getString("code"));
			role.setName(resultSet.getString("name"));
			userModel.setRole(role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userModel;
	}

}
