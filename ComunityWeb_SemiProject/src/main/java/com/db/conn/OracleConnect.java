package com.db.conn;

import java.io.*;
import java.sql.*;
import java.util.*;

public class OracleConnect {
	private Properties info = new Properties();
	private Connection conn = null;
	private Statement state = null;
	
	{
		String userHome = System.getProperty("user.dir");
		userHome = userHome.substring(0, userHome.lastIndexOf("\\"));
		try {
			this.info.load(new FileReader(userHome + "/oracle_connection_idpw.prop"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public OracleConnect(){
		this.connect();
	}
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection(this.info.getProperty("localDBURL"), this.info.getProperty("userName"), this.info.getProperty("userPassword"));
			this.conn.setAutoCommit(false); //수동 커밋 사용 설정. (true)면 자동커밋
			this.state = this.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			this.state.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//select 문 으로 결과 반환
	public ResultSet selectData(String query) {
		ResultSet sqlData = null;
		try {
			sqlData = this.state.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sqlData;
	}
	//insert, delete 등 내용변경 query 사용 (0: 비정상, 1: 정상) 
	public int insertData(String query) {
		int updateNum = 0;
		try {
			updateNum = this.state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateNum;
	}
	public int updaetData(String query) {
		return this.insertData(query);
	}
	public int deleteData(String query) {
		return this.insertData(query);
	}
	
	public void commit() {
		try {
			this.conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rollback() {
		try {
			this.conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
