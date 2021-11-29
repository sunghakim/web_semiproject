package com.db.conn;

import java.io.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.pool.OracleDataSource;

public class OracleConnect {
	private Properties info = new Properties();
	private Connection conn = null;
	private Statement stat = null;
	
	// 초기화 블럭
	{
		// 1. 데이터베이스 연결 구성 정보가 있는 파일 불러오기
		String userHome = System.getProperty("user.home");
		try {
			this.info.load(new FileReader(userHome + "/oracle_connection.prop"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Oracle Database 연결을 위한 과정
	 * 	1. 데이터베이스 연결 구성 정보 생성
	 * 	2. 연결 구성 정보로 데이터베이스 연결
	 * 	3. 생성된 연결정보로 Statement 생성
	 * 	4. 생성된 Statement로 Query 전송
	 * 	5. ResultSet 받아서 필요한 내부 처리 진행
	 * 	6. 모든 내부 처리 완료 후 자원 반납.(close 작업)
	 */
	public OracleConnect() {
		this.connect();
	}
	
	public OracleConnect(boolean wallet) {
		if(wallet) {
			this.walletConnect();
		} else {
			this.connect();
		}
	}
	
	// Wallet 정보로 데이터베이스 연결
	private void walletConnect() {
		OracleDataSource ods;
		try {
			ods = new OracleDataSource();
			ods.setURL(this.info.getProperty("cloud-url"));
			ods.setConnectionProperties(this.info);
			this.conn = ods.getConnection();
			this.conn.setAutoCommit(false);
			this.stat = this.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 기본 정보로 데이터베이스 연결
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection(
					this.info.getProperty("local-url"),
					this.info.getProperty("user"),
					this.info.getProperty("password"));
			this.conn.setAutoCommit(false);
			this.stat = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 설정된 SQL Query를 실행후 결과를 반환한다.
	public ResultSet select(String query) {
		ResultSet rs = null;
		try {
			rs = this.stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insert(String query) {
		int rs = 0;
		try {
			rs = this.stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int update(String query) {
		return insert(query);
	}
	
	public int delete(String query) {
		return insert(query);
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
	
	public void close() {
		try {
			this.stat.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
