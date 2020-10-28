package com.document.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.document.controller.DBConnection;
import com.document.m_interface.DAO;
import com.document.model.Person;

public class PersonDAO implements DAO<Person>{

	public Person getPerson(String perId) {
		Connection connection  = DBConnection.getInstance().getConnection();
		String sql = "SELECT * FROM LIBRARY.PERSON WHERE PERID = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, perId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String perName = resultSet.getString("perName");
				String perAddress = resultSet.getString("perAddress");
				String perDob = resultSet.getString("perDob");
				String perGender = resultSet.getString("perGender");
				
				return new Person(perId, perName, perAddress, perDob, perGender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void add(Person person) {
		Connection connection  = DBConnection.getInstance().getConnection();
		String sql = "INSERT INTO LIBRARY.PERSON VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, person.getPerId());
			statement.setString(2, person.getPerName());
			statement.setString(3, person.getPerAddress());
			statement.setString(4, person.getPerDob());
			statement.setString(5, person.getPerGender());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> show() {
		
		return null;
	}
}
