package com.rajat.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//1.2 Connect
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajat?useSSL=false&allowPublicKeyRetrieval=true", "root", "rajatjain");
		
		return connection;
	}

}
