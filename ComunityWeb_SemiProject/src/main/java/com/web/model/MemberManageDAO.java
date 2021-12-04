package com.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberManageDAO {

	//db 주소
	private String dbURL = "";
	private String dbID = "";
	private String dbPassword = "";

	public MemberManageDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<AccountDTO> memberList() {
		List<AccountDTO> memberList = new ArrayList<>();
		String SQL = "SELECT USER_ID, PASSWORD FROM ACCOUNTDB";

		try (// db 접속, 쿼리 try-with-resource 사용
				Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				String id = rs.getString(1);
				String password = rs.getString(2);
				memberList.add(new AccountDTO(id, password));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberList;
	}

	public int memberDelete(String[] ids) {
		String SQL = "DELETE ACCOUNTDB WHERE USER_ID IN (?)";
		
		StringBuffer id = new StringBuffer();
		
		for(int i = 0; i < ids.length; i++) {
			id.append(ids[i]);
			if(i < ids.length - 1)
				id.append(",");
		}
		
		System.out.println("삭제한 ID : "+ id);
		
		try (Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				PreparedStatement pstmt = conn.prepareStatement(SQL);) {
			pstmt.setString(1, id.toString());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
