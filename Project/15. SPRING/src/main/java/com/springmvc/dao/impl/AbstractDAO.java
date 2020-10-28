package com.springmvc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.springmvc.dao.IGenericDAO;
import com.springmvc.mapper.IRowMapper;

public class AbstractDAO<T> implements IGenericDAO<T>{
	
//	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
//			  Class.forName(resourceBundle.getString("driverName")); 
//			  String url = resourceBundle.getString("url"); 
//			  String user = resourceBundle.getString("user"); 
//			  String pass = resourceBundle.getString("pass");
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/jspservletjdbc"; 
			String user = "root"; 
			String pass = "Tungtung96";
			
			
			 
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
		List<T> list = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try{
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				list.add(rowMapper.mapRow(resultSet));
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {	
		try {
			for(int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				if(parameter instanceof Long) {
					statement.setLong(i + 1, (Long) parameter);
				} else if(parameter instanceof String) {
					statement.setString(i + 1, (String) parameter);
				}else if(parameter instanceof Integer) {
					statement.setInt(i + 1, (Integer) parameter);
				}else if(parameter instanceof Timestamp) {
					statement.setTimestamp(i + 1, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int count(String sql, Object... parameters) {
		int count = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try{
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
}
