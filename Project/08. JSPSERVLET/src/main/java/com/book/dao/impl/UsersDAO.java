package com.book.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.book.dao.IUsersDAO;
import com.book.mapper.UsersMapper;
import com.book.model.Users;

public class UsersDAO extends AbstractDAO implements IUsersDAO{

	@Override
	public List<Users> findAll() {
		String sql = "SELECT * FROM users";
		return query(sql, new UsersMapper());
	}

	@Override
	public int add(Users user) {
		ResultSet resultSet = null;
		int id = 0;
		String sql = "INSERT INTO users(username, password, fullname) VALUES(?, ?, ?)";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPass());
			statement.setString(3, user.getFullName());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next())
				id =  resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Users findOne(int id) {
		return null;
	}
	
}
