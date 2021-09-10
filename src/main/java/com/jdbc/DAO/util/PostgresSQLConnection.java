package com.jdbc.DAO.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresSQLConnection {
	
	private static Connection connection;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://my8weeksinstance.cjfjnd6bxxdf.us-west-1.rds.amazonaws.com:5432/postgres";
		String user = "";
		String password = "";
		
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}

}
