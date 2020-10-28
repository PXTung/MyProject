package com.document.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.document.controller.DBConnection;
import com.document.model.Person;
import com.document.model.Reader;

public class ReaderDAO extends PersonDAO{
	
	public ReaderDAO() {
		
	}
	
	public static ReaderDAO getInstance() {
		return new ReaderDAO();
	}
	
	@Override
	public void add(Person person) {
		super.add(person);
		Reader reader = (Reader)person;
		Connection connection  = DBConnection.getInstance().getConnection();
		String sql = "INSERT INTO LIBRARY.READER VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, reader.getRedId());
			statement.setString(2, reader.getRedType());
			statement.setString(3, reader.getRedPhone());
			statement.setString(4, reader.getRedEmail());
			statement.setString(5, reader.getPerId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Person> show() {
		List<Person> readers = new ArrayList<Person>();
		Connection connection  = DBConnection.getInstance().getConnection();
		String sql = "SELECT * FROM LIBRARY.READER";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String redId = resultSet.getString("redId");
				String redType = resultSet.getString("redType");
				String redPhone = resultSet.getString("redPhone");
				String redEmail = resultSet.getString("redEmail");
				String perId = resultSet.getString("perId");
				
				Reader reader = new Reader(getPerson(perId), redId, redType, redPhone, redEmail);
				readers.add(reader);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return readers;
	}
}