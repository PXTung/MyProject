package com.document.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public DBConnection() {
		
	}
	
	public static DBConnection getInstance() {
		return new DBConnection();
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/library";
			String user = "root";
			String pass = "Tungtung96";
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			if(connection != null)
				return connection;
			else
				System.out.println("Connection Fail");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
