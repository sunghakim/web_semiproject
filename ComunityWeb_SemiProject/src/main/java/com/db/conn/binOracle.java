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
	private static String dbURL = "";
	private static String dbID = "";
	private static String dbPassword = "";
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(dbURL, dbID, dbPassword);
	}

}
