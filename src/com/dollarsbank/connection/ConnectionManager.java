package com.dollarsbank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	//Change database credentials here
	private static final String URL = "jdbc:mysql://localhost:3206/dollar_bank";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	private static Connection conn = null;

	//Make connection
	private static void makeConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Get connection
	public static Connection getConnection() {
		if(conn == null) {
			makeConnection();
		}
		return conn;
	}
}
