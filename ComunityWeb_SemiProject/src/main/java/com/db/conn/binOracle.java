package com.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class binOracle {
	
	private binOracle() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	private static String dbURL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private static String dbID = "TEST_USER2";
	private static String dbPassword = "1234";
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(dbURL, dbID, dbPassword);
	}

}
