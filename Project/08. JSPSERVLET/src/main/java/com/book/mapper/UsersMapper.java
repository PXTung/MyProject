package com.book.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.model.Users;

public class UsersMapper implements IRowMapper<Users>{

	@Override
	public Users mapRow(ResultSet resultSet) {
		Users user = new Users();
		try {
			user.setId(resultSet.getInt("id"));
			user.setUserName(resultSet.getString("username"));
			user.setPass(resultSet.getString("password"));
			user.setFullName(resultSet.getString("fullname"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
